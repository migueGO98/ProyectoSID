package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum TipoContratacionesEnum {

    SP("Servicio Profesional"),
    EE("Estructura Eventual"),
    INCA("INCA");

    private final String contratacion;

    TipoContratacionesEnum(String contratacion) {
        this.contratacion = contratacion;
    }
}
