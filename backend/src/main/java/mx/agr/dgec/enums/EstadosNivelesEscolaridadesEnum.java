package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum EstadosNivelesEscolaridadesEnum {
    CREDITOS_CUBIERTOS("Créditos cubiertos"),
    CERTIFICADO("Certificado"),
    PASANTE("Pasante"),
    TITULADO("Titulado"),
    TRAMITE_TITULACION("Titulo en trámite"),
    TRUNCA("Trunca");

    private final String estadoNivel;

    EstadosNivelesEscolaridadesEnum(String estadoNivel) { this.estadoNivel = estadoNivel; }
}
