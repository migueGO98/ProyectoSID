package mx.agr.dgec.SID.enums;

import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.generate.model.EstadoCivilEnumDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EstadoCivilEnumTest {

    /**
     * Validar que el tamaño de EstadosCivilesEnumDto
     * sea el mismo que EstadosCivilesEnum
     */
    @Test
    void validarSizeEstadosCivilesEnum() {
        // Arrange
        var estadosCivilesSizeEsperado = EstadoCivilEnum.values().length;

        // Act
        var estadosCivilesDto = EstadoCivilEnumDto.values().length;

        // Assert
        assertEquals(estadosCivilesSizeEsperado, estadosCivilesDto, "El tamaño de los enums de los Estados Civiles no es el mismo");
    }

    /**
     * Validar que los valores de EstadosCivilesEnumDto
     * sean iguales a los de EstadosCivilesEnum
     */
    @Test
    void validarValoresEstadosCivilesEnum() {
        // Arrange
        var estadosCivilesEsperados = EstadoCivilEnum.values();
        var estadosCivilesDto = EstadoCivilEnumDto.values();

        // Act with stream
        for( int i = 0; i < estadosCivilesDto.length; i++ ) {
            // Assert
            assertEquals(estadosCivilesEsperados[i].name(), estadosCivilesDto[i].name(), "EstadosCivilesEnumDto no tiene los mismos valores que EstadosCivilesEnum");
        }
    }

}
