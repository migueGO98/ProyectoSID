package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum EstadoCivilEnum {
    SOLTERO("Soltero"),
    SOLTERA("Soltera"),
    CASADO("Casado"),
    CASADA("Casada"),
    DIVORCIADO("Divorciado"),
    DIVORCIADA("Divorciada"),
    VIUDO("Viudo"),
    VIUDA("Viuda"),
    SEPARADO("Separado"),
    SEPARADA("Separada"),
    UNION_LIBRE("Unión libre");

    private final String estadoCivil;

    EstadoCivilEnum(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
