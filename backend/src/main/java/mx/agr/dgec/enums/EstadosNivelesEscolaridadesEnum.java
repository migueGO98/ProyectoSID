package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum EstadosNivelesEscolaridadesEnum {
    TITULADO("Titulado"),
    PASANTE("Pasante"),
    CREDITOS_CUBIERTOS("Créditos cubiertos"),
    TRAMITE_TITULACION("Trámite de titulación"),
    TRUNCA("Trunca"),
    CERTIFICADO("Certificado");

    private final String estadoNivel;

    EstadosNivelesEscolaridadesEnum(String estadoNivel) { this.estadoNivel = estadoNivel; }
}
