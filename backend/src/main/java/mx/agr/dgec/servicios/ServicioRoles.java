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
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class ServicioRoles {

    @Autowired
    RepositorioRol repositorioRoles;

    public List<RolDto> recuperarRoles() {
        var roles = repositorioRoles.findAll();
        log.info("Se recuperaron los roles {}", roles);
        return RolMapper.INSTANCE.rolesToRolesDto(roles);
    }

    public Set<Rol> obtenerRoles(List<String> roles){

        Objects.requireNonNull(roles, "La lista de roles no puede ser nula");
        if(roles.isEmpty()) throw new IllegalArgumentException("La lista de roles no puede estar vacía");

        roles.forEach(r -> {
            if(r == null) throw new IllegalArgumentException("La lista de roles no puede tener valores nulos");
            if(r.isBlank()) throw new IllegalArgumentException("La lista de roles no puede tener valores vacíos");
        });

        var rolesSinDuplicados = roles.stream()
                .map(String::toUpperCase)
                .distinct()
                .toList();

        if(rolesSinDuplicados.size() != roles.size()) throw new IllegalArgumentException("La lista de roles contiene roles duplicados");

        var listaRoles = repositorioRoles.findAllById(rolesSinDuplicados);

        if(listaRoles.size() != rolesSinDuplicados.size()) throw new IllegalArgumentException("La lista de roles contiene roles no válidos o inexistentes");

        return new HashSet<>(listaRoles);
    }

}
