package mx.agr.dgec.SID.enums;

import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.generate.model.EstadoCivilEnumDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EstadoCivilEnumTest {

    /**
     * Validar que el tamaño de EstadosCivilesEnumDto
     * sea el mismo que EstadosCivilesEnum
     */
    @Test
    void validarSizeEstadosCivilesEnum() {
        // Arrange
        var estadosCivilesEsperado = EstadoCivilEnum.values();

        // Act
        var estadosCivilesDto = EstadoCivilEnumDto.values();

        // Assert
        assertEquals(estadosCivilesEsperado.length, estadosCivilesDto.length, "El tamaño de los enums de los Estados Civiles no es el mismo");
    }

    /**
     * Validar que los valores de EstadosCivilesEnumDto
     * sean iguales a los de EstadosCivilesEnum
     */
    @Test
    void validarValoresEstadosCivilesEnum() {
        // Arrange
        var estadosCivilesEsperados = Arrays.stream(EstadoCivilEnum.values()).map(EstadoCivilEnum::name).collect(Collectors.toSet());
        var estadosCivilesDto = Arrays.stream(EstadoCivilEnumDto.values()).map(EstadoCivilEnumDto::name).collect(Collectors.toSet());

        // Act with stream
            // Validar que los valores de EstadosCivilesEnumDto estén en EstadosCivilesEnum
        boolean estadosCivilesDtoInEstadosCiviles = estadosCivilesEsperados.containsAll(estadosCivilesDto);
            // Validar que los valores de EstadosCivilesEnum estén en EstadosCivilesEnumDto
        boolean estadosCivilesInEstadosCivilesDto = estadosCivilesDto.containsAll(estadosCivilesEsperados);

        // Assert
        assertTrue(estadosCivilesDtoInEstadosCiviles, "Hay valores en EstadosCivilesEnumDto que no están en EstadosCivilesEnum");
        assertTrue(estadosCivilesInEstadosCivilesDto, "Hay valores en EstadosCivilesEnum que no están en EstadosCivilesEnumDto");
    }

}
