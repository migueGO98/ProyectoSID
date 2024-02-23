package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.agr.dgec.enums.EstadosNivelesEscolaridadesEnum;
import mx.agr.dgec.enums.NivelesEscolaridadesEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escolaridad {
    private String idEmpleado;
    private NivelesEscolaridadesEnum nivel;
    private String carrera;
    private EstadosNivelesEscolaridadesEnum estadoNivel;
    private Boolean conCedulaProfesional;
    private String cedulaProfesional;
}
