package mx.agr.dgec.enums;

import mx.agr.dgec.enums.EstadosNivelesEscolaridadesEnum;
import mx.agr.dgec.generate.model.EstadosNivelesEscolaridadesEnumDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EstadosNivelesEscolaridadesEnumTest {

    /**
     * Validar que el tamaño de EstadosNivelesEscolaridadesEnumDto
     * sea el mismo que EstadosNivelesEscolaridadesEnum
     */
    @Test
    void validarSizeEstadosNivelesEscolaridadesEnum() {
        // Arrange
        var estadosNivelesEscolaridadesEsperado = EstadosNivelesEscolaridadesEnum.values();

        // Act
        var estadosNivelesEscolaridadesDto = EstadosNivelesEscolaridadesEnumDto.values();

        // Assert
        assertEquals(estadosNivelesEscolaridadesEsperado.length, estadosNivelesEscolaridadesDto.length, "El tamaño de los enums de los Estados de Niveles de Escolaridades no es el mismo");
    }

    /**
     * Validar que los valores de EstadosNivelesEscolaridadesEnumDto
     * sean iguales a los de EstadosNivelesEscolaridadesEnum
     */
    @Test
    void validarValoresEstadosNivelesEscolaridadesEnum() {
        // Arrange
        var estadosNivelesEscolaridadesEsperados = Arrays.stream(EstadosNivelesEscolaridadesEnum.values()).map(EstadosNivelesEscolaridadesEnum::name).collect(Collectors.toSet());
        var estadosNivelesEscolaridadesDto = Arrays.stream(EstadosNivelesEscolaridadesEnumDto.values()).map(EstadosNivelesEscolaridadesEnumDto::name).collect(Collectors.toSet());

        // Act
        boolean estadosNivelesEscolaridadesDtoInEstadosNivelesEscolaridades = estadosNivelesEscolaridadesEsperados.containsAll(estadosNivelesEscolaridadesDto);
        boolean estadosNivelesEscolaridadesInEstadosNivelesEscolaridadesDto = estadosNivelesEscolaridadesDto.containsAll(estadosNivelesEscolaridadesEsperados);

        // Assert
        assertTrue(estadosNivelesEscolaridadesDtoInEstadosNivelesEscolaridades, "Hay valores en EstadosNivelesEscolaridadesEnumDto que no están en EstadosNivelesEscolaridadesEnum");
        assertTrue(estadosNivelesEscolaridadesInEstadosNivelesEscolaridadesDto, "Hay valores en EstadosNivelesEscolaridadesEnum que no están en EstadosNivelesEscolaridadesEnumDto");
    }
}
