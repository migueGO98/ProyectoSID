package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum EstadoCivilEnum {
    CASADO("Casado"),
    CASADA("Casada"),
    SOLTERO("Soltero"),
    SOLTERA("Soltera"),
    VIUDO("Viudo"),
    VIUDA("Viuda"),
    SEPARADO("Separado"),
    SEPARADA("Separada"),
    DIVORCIADO("Divorciado"),
    DIVORCIADA("Divorciada"),
    UNION_LIBRE("Unión libre");

    private final String estadoCivil;

    EstadoCivilEnum(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
