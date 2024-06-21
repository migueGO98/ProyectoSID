package mx.agr.dgec.seguridad;

import lombok.RequiredArgsConstructor;
import mx.agr.dgec.enums.MetodosHttpEnum;
import mx.agr.dgec.servicios.ServicioEndpoints;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Aspecto que se encarga de verificar si el usuario autenticado tiene los roles necesarios para acceder a un endpoint.
 * Consulta el ServicioEndpoints para obtener los roles permitidos de un endpoint y compara con los roles del usuario.
 * Si el usuario no tiene los roles necesarios, lanza una excepción de acceso denegado.
 */
@Aspect
@Component
@RequiredArgsConstructor
public class DynamicRolesAllowedAspect {

    private final ServicioEndpoints servicioEndpoints;

    @Around("@annotation(dynamicRolesAllowed)") // Se ejecuta alrededor de métodos anotados con @DynamicRolesAllowed
    public Object checkDynamicRoles(ProceedingJoinPoint joinPoint, DynamicRolesAllowed dynamicRolesAllowed) throws Throwable {
        MetodosHttpEnum metodoHttp = dynamicRolesAllowed.metodoHttp();
        String rutaEndpoint = dynamicRolesAllowed.rutaEndpoint();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var rolesPermitidosDelEndpoint = servicioEndpoints.obtenerRolesPermitidosDelEndpoint(metodoHttp, rutaEndpoint);

        boolean tieneRolesPermitidos = authentication.getAuthorities().stream()
                .anyMatch(authority -> rolesPermitidosDelEndpoint.contains(authority.getAuthority()));

        if (!tieneRolesPermitidos) {
            throw new AccessDeniedException("El usuario no tiene los roles necesarios.");
        }

        return joinPoint.proceed(); // Continuar con la ejecución del método
    }
}
