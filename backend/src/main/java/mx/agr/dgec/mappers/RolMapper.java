package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Rol;
import mx.agr.dgec.generate.model.RolDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    List<RolDto> rolesToRolesDto(List<Rol> roles);

    /**
     * Este método solo recupera su descripción, es muy usado en el servicio de empleados
     * cuando se recuperan los empleados o se crea un nuevo empleado
     */
    default Set<String> rolesToDescripcion(Set<Rol> roles){
        return roles.stream().map(Rol::getDescripcion).collect(Collectors.toSet());
    }

}
