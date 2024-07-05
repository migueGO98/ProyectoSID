package mx.agr.dgec.servicios;

import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.enums.GeneroEnum;
import mx.agr.dgec.generate.model.RegistrosDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ServicioPersonasTest {

    @InjectMocks
    private ServicioPersonas servicioPersonas;

    @Test
    void recuperarEstadosCiviles() {
        // Arrange
        var estadosCivilesEsperados = Arrays.stream(EstadoCivilEnum.values())
                .map(estadoCivil -> new RegistrosDto(estadoCivil.name(), estadoCivil.getEstadoCivil()))
                .toList();

        // Act
        var estadosCiviles = servicioPersonas.recuperarEstadosCiviles();

        // Assert
        assertEquals(estadosCivilesEsperados, estadosCiviles, "Hay diferentes registros de estados civiles");
    }

    @Test
    void recuperarGeneros() {
        // Arrange
        var generosEsperados = Arrays.stream(GeneroEnum.values())
                .map(genero -> new RegistrosDto(genero.name(), genero.getGenero()))
                .toList();

        // Act
        var generos = servicioPersonas.recuperarGeneros();

        // Assert
        assertEquals(generosEsperados, generos, "Hay diferentes registros de géneros");
    }
}
