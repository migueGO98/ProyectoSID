package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum NivelesEscolaridadesEnum {
    TECNICO("Técnico"),
    LICENCIATURA("Licenciatura"),
    MAESTRIA("Maestría"),
    ESPECIALIDAD("Especialidad"),
    DOCTORADO("Doctorado"),
    BACHILLERATO("Bachillerato"),
    DIPLOMADO("Diplomado");

    private final String nivel;

    NivelesEscolaridadesEnum(String nivel) { this.nivel = nivel; }

}
