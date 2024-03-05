package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum GenerosEnum {

    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    NO_BINARIO("No binario"),
    OTRO("Otro");

    private final String genero;

    GenerosEnum(String genero) { this.genero = genero; }
}
