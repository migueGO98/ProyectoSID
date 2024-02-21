package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum TipoContratacionEnum {
    SP("Servicio Profesional"),
    EE("Estructura Eventual"),
    INCA("Externo - INCA");

    private final String tipoContratacion;

    TipoContratacionEnum(String tipoContratacion) { this.tipoContratacion = tipoContratacion; }
}
