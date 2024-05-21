package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Rol;
import mx.agr.dgec.generate.model.RolDto;
import mx.agr.dgec.mappers.RolMapper;
import mx.agr.dgec.repositorios.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ServicioRoles {

    @Autowired
    private RepositorioRol repositorioRoles;

    public List<RolDto> recuperarRoles() {
        var roles = repositorioRoles.findAll();
        log.info("Se recuperaron los roles {}", roles);
        return RolMapper.INSTANCE.rolesToRolesDto(roles);
    }

    public Set<Rol> obtenerRoles(List<String> roles) {
        var rolesUpper = roles.stream()
                .map(String::toUpperCase)
                .toList();
        var listaRoles = repositorioRoles.findAllById(rolesUpper);

        if(listaRoles.size() != rolesUpper.size()) throw new IllegalArgumentException("La lista de roles contiene roles no válidos o inexistentes");

        return new HashSet<>(listaRoles);
    }

}
