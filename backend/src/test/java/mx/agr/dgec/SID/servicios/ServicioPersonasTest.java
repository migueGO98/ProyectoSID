package mx.agr.dgec.SID.servicios;

import mx.agr.dgec.enums.EstadoCivilEnum;
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
class ServicioPersonasTest {

    @InjectMocks
    private ServicioPersonas servicioPersonas;

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
}
