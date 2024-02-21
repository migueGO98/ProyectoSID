package mx.agr.dgec.enums;

import lombok.Getter;

@Getter
public enum NivelesEscolaridadesEnum {
    BACHILLERATO("Bachillerato"),
    TECNICO("Técnico"),
    LICENCIATURA("Licenciatura"),
    MAESTRIA("Maestría"),
    DOCTORADO("Doctorado"),
    ESPECIALIDAD("Especialidad"),
    DIPLOMADO("Diplomado");

    private final String nivel;

    NivelesEscolaridadesEnum(String nivel) { this.nivel = nivel; }

}
