package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum MotivoBajaEnum {
    TERMINO_CONTRATO("Termino de contrato"),
    RENUNCIA("Renuncia"),
    LIQUIDACION("Liquidación");

    private final String motivoBaja;

    MotivoBajaEnum(String motivoBaja) { this.motivoBaja = motivoBaja; }
}
