package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Escolaridad;
import mx.agr.dgec.enums.EstadosNivelesEscolaridadesEnum;
import mx.agr.dgec.enums.NivelesEscolaridadesEnum;
import mx.agr.dgec.generate.model.EscolaridadDto;
import mx.agr.dgec.generate.model.EstadosNivelesEscolaridadesEnumDto;
import mx.agr.dgec.generate.model.NivelesEscolaridadesEnumDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = {JsonNullableMapper.class})
public interface EscolaridadMapper {

    EscolaridadMapper INSTANCE = Mappers.getMapper(EscolaridadMapper.class);

    NivelesEscolaridadesEnum toNivelesEscolaridadesEnum(NivelesEscolaridadesEnumDto nivel);

    EstadosNivelesEscolaridadesEnum toEstadosNivelesEscolaridadesEnum(EstadosNivelesEscolaridadesEnumDto estadoNivel);

    Escolaridad escolaridadDtoToEscolaridad(String idEmpleado, EscolaridadDto escolaridad);

    default List<Escolaridad> listEscolaridadDtoToListEscolaridad(String idEmpleado, List<EscolaridadDto> escolaridades){
        return escolaridades.stream().map(escolaridad -> escolaridadDtoToEscolaridad(idEmpleado, escolaridad)).toList();
    }

    default List<RegistrosDto> nivelesEscolaridadesEnumToRegistrosDto(List<NivelesEscolaridadesEnum> niveles){
        return niveles.stream().map(nivel -> new RegistrosDto(nivel.name(), nivel.getNivel())).toList();
    }

    default List<RegistrosDto> estadosNivelesEscolaridadesEnumToRegistrosDto(List<EstadosNivelesEscolaridadesEnum> estados){
        return estados.stream().map(estado -> new RegistrosDto(estado.name(), estado.getEstadoNivel())).toList();
    }
}
