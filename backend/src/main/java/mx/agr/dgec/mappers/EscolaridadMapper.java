package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Escolaridad;
import mx.agr.dgec.enums.EstadosNivelesEscolaridadesEnum;
import mx.agr.dgec.enums.NivelesEscolaridadesEnum;
import mx.agr.dgec.generate.model.EscolaridadDto;
import mx.agr.dgec.generate.model.EstadosNivelesEscolaridadesEnumDto;
import mx.agr.dgec.generate.model.NivelesEscolaridadesEnumDto;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface EscolaridadMapper {
    EscolaridadMapper INSTANCE = Mappers.getMapper(EscolaridadMapper.class);

    @ValueMapping(source = "TECNICO", target = "TECNICO")
    @ValueMapping(source = "LICENCIATURA", target = "LICENCIATURA")
    @ValueMapping(source = "MAESTRIA", target = "MAESTRIA")
    @ValueMapping(source = "ESPECIALIDAD", target = "ESPECIALIDAD")
    @ValueMapping(source = "DOCTORADO", target = "DOCTORADO")
    @ValueMapping(source = "BACHILLERATO", target = "BACHILLERATO")
    @ValueMapping(source = "DIPLOMADO", target = "DIPLOMADO")
    NivelesEscolaridadesEnum toNivelesEscolaridadesEnum(NivelesEscolaridadesEnumDto nivel);

    @ValueMapping(source = "CREDITOS_CUBIERTOS", target = "CREDITOS_CUBIERTOS")
    @ValueMapping(source = "CERTIFICADO", target = "CERTIFICADO")
    @ValueMapping(source = "PASANTE", target = "PASANTE")
    @ValueMapping(source = "TITULADO", target = "TITULADO")
    @ValueMapping(source = "TRAMITE_TITULACION", target = "TRAMITE_TITULACION")
    @ValueMapping(source = "TRUNCA", target = "TRUNCA")
    EstadosNivelesEscolaridadesEnum toEstadosNivelesEscolaridadesEnum(EstadosNivelesEscolaridadesEnumDto estadoNivel);


    // Metodo para parsear de EscolaridadDto a Escolaridad por los enums
    default List<Escolaridad> toEscolaridad(String idEmpleado, List<EscolaridadDto> escolaridadDto) {
        return escolaridadDto.stream().map(escolaridad ->
            new Escolaridad(
                idEmpleado,
                toNivelesEscolaridadesEnum(escolaridad.getNivel()),
                escolaridad.getCarrera(),
                toEstadosNivelesEscolaridadesEnum(escolaridad.getEstadoNivel()),
                escolaridad.getConCedulaProfesional(),
                escolaridad.getCedulaProfesional()
            )
        ).toList();
    }
}
