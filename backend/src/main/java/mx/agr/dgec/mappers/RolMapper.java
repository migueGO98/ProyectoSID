package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Rol;
import mx.agr.dgec.generate.model.RolDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.Set;

@Mapper
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    List<RolDto> rolesToRolesDto(List<Rol> roles);

    default List<String> rolesToIdRoles(Set<Rol> roles){
        return roles.stream().map(Rol::getIdRol).toList();
    }

}
