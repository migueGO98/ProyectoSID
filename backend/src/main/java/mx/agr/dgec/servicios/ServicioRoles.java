package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Rol;
import mx.agr.dgec.exceptions.ElementoNoEncontradoException;
import mx.agr.dgec.generate.model.RolDto;
import mx.agr.dgec.mappers.RolMapper;
import mx.agr.dgec.repositorios.RepositorioRol;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioRoles {

    private final RepositorioRol repositorioRoles;

    public List<RolDto> recuperarRoles() {
        var roles = repositorioRoles.findAll();
        log.info("Se recuperaron los roles");
        return RolMapper.INSTANCE.rolesToRolesDto(roles);
    }

    public Set<Rol> obtenerRoles(List<String> roles) {
        var rolesUpper = roles.stream()
                .map(String::toUpperCase)
                .toList();
        var listaRoles = repositorioRoles.findAllById(rolesUpper);

        if(listaRoles.size() != rolesUpper.size()) throw new ElementoNoEncontradoException("La lista de roles tiene id's no existentes");

        return new HashSet<>(listaRoles);
    }

}
