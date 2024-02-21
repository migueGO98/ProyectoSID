package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum TipoPlazaEnum {
    SP( "Servicio Profesional"),
    EE("Estructura Eventual"),
    INCA("Externo - INCA");

    private final String nombrePlaza;

    TipoPlazaEnum(String nombrePlaza) { this.nombrePlaza = nombrePlaza; }
}
