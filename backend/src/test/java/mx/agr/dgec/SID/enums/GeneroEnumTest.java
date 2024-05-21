package mx.agr.dgec.SID.enums;

import mx.agr.dgec.enums.GeneroEnum;
import mx.agr.dgec.generate.model.GeneroEnumDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class GeneroEnumTest {

    /**
     * Validar que el tamaño de GeneroEnumDto
     * sea el mismo que GeneroEnum
     */
    @Test
    void validarSizeGeneroEnum() {
        // Arrange
        var generosEsperado = GeneroEnum.values();

        // Act
        var generosDto = GeneroEnumDto.values();

        // Assert
        assertEquals(generosEsperado.length, generosDto.length, "El tamaño de los enums de los Géneros no es el mismo");
    }


    /**
     * Validar que los valores de GeneroEnumDto
     * sean iguales a los de GeneroEnum
     */
    @Test
    void validarValoresGeneroEnum() {
        // Arrange
        var generosEsperados = Arrays.stream(GeneroEnum.values()).map(GeneroEnum::name).collect(Collectors.toSet());
        var generosDto = Arrays.stream(GeneroEnumDto.values()).map(GeneroEnumDto::name).collect(Collectors.toSet());

        // Act
            // Validar que los valores de GeneroEnumDto estén en GeneroEnum
        boolean generosDtoInGenero = generosEsperados.containsAll(generosDto);
            // Validar que los valores de GeneroEnum estén en GeneroEnumDto
        boolean generosInGeneroDto = generosDto.containsAll(generosEsperados);

        // Assert
        assertTrue(generosDtoInGenero, "Hay valores en GeneroEnumDto que no están en GeneroEnum");
        assertTrue(generosInGeneroDto, "Hay valores en GeneroEnum que no están en GeneroEnumDto");
    }
}
