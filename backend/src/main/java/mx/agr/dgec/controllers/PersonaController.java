package mx.agr.dgec.controllers;

import mx.agr.dgec.generate.api.PersonasApi;
import mx.agr.dgec.generate.model.PersonaCreadaDto;
import mx.agr.dgec.generate.model.PersonaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController implements PersonasApi {
    @Override
    public ResponseEntity<PersonaCreadaDto> crearNuevaPersona(PersonaDto personaDto) {
        return null;
    }
}
