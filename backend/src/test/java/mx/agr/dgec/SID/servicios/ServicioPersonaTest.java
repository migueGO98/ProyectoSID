package mx.agr.dgec.SID.servicios;

import mx.agr.dgec.generate.model.PersonaDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.servicios.ServicioPersonas;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.jackson.nullable.JsonNullable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ServicioPersonaTest {

    @InjectMocks
    private ServicioPersonas servicioPersonas;

    @Test
    void obtenerValoresEstadosCivilesDelENUM() {
        // Simulación de llamada al método
        var estadosCiviles = servicioPersonas.recuperarEstadosCiviles();

        // Verificación que solo recupere 11 valores permitidos
        assertEquals(11, estadosCiviles.size());

        // Valores esperados
        String[] valoresEsperados = {"Casado", "Casada", "Soltero",
                "Soltera", "Viudo", "Viuda", "Separado", "Separada",
                "Divorciado", "Divorciada", "Unión libre"};

        // Verificación de que los valores son los esperados
        int i = 0;
        for (RegistrosDto estadoCivil : estadosCiviles) {
            assertEquals(valoresEsperados[i++], estadoCivil.getDescripcion());
        }
    }

    @Test
    void obtenerValoresGenerosDelENUM() {
        // Simulación de llamada al método
        var generos = servicioPersonas.recuperarGeneros();

        // Verificación que solo recupere 4 valores permitidos
        assertEquals(4, generos.size());

        // Valores esperados
        String[] valoresEsperados = {"Masculino", "Femenino", "No binario", "Otro"};

        // Verificación de que los valores son los esperados
        int i = 0;
        for (RegistrosDto genero : generos) {
            assertEquals(valoresEsperados[i++], genero.getDescripcion());
        }
    }

    @Test
    void probarExcepcionesParavalidarPersonaDto() {
        // Simulación de llamada al método
        var personaDto = new PersonaDto();
        personaDto.setNombre("");
        personaDto.setApellidoPaterno("");
        personaDto.setApellidoMaterno(JsonNullable.of(""));
        personaDto.setCurp("");
        personaDto.setRfc("");
        personaDto.setNumeroSeguroSocial("");
        personaDto.setTelefonoPersonal("");
        personaDto.setCorreoElectronicoPersonal("");
        personaDto.setContactoEmergenciaNombre("");
        personaDto.setContactoEmergenciaTelefono("");

        // Verificación de que se lance una excepción
        var exception = assertThrows(IllegalArgumentException.class, () -> servicioPersonas.validarPersonaDto(personaDto));
        var mensajeEsperado = "El nombre no puede ser nulo o vacío";
        assertEquals(mensajeEsperado, exception.getMessage());
    }

}
