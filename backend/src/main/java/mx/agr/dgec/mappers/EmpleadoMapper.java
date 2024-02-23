package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Empleado;
import mx.agr.dgec.entidades.Persona;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DomicilioMapper.class, EscolaridadMapper.class})
public interface EmpleadoMapper {
    EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);
}
