package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum GeneroEnum {

    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    NO_BINARIO("No binario"),
    OTRO("Otro");

    private final String genero;

    GeneroEnum(String genero) { this.genero = genero; }
}
