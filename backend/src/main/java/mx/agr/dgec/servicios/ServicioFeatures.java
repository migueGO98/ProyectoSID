package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.enums.MetodosHttpEnum;
import mx.agr.dgec.repositorios.RepositorioFeatures;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioFeatures {

    private final RepositorioFeatures repositorioFeatures;

    public Set<String> obtenerRolesPermitidosDelEndpoint(MetodosHttpEnum metodoHttp, String endPoint) {
        var rolesPermitidos = repositorioFeatures.findIdRolesByMetodoHttpAndEndpoint(metodoHttp, endPoint);
        log.info("Se recuperaron los roles permitidos para el método {} y la ruta {}", metodoHttp, endPoint);
        log.info("Roles permitidos: {}", rolesPermitidos);
        return rolesPermitidos;
    }
}
