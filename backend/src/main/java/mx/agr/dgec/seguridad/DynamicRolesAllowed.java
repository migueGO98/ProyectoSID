package mx.agr.dgec.seguridad;

import mx.agr.dgec.enums.MetodosHttpEnum;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE}) // Esta anotación se aplica solo a métodos
@Retention(RetentionPolicy.RUNTIME) // La anotación estará disponible en tiempo de ejecución
@Inherited
@Documented
public @interface DynamicRolesAllowed {
    MetodosHttpEnum metodoHttp();
    String rutaEndpoint();
}
