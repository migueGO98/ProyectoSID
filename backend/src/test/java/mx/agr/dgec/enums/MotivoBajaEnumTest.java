package mx.agr.dgec.enums;

import mx.agr.dgec.enums.GeneroEnum;
import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.generate.model.GeneroEnumDto;
import mx.agr.dgec.generate.model.MotivoBajaEnumDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class MotivoBajaEnumTest {

    /**
     * Validar que el tamaño de MotivoBajaEnumDto
     * sea el mismo que MotivoBajaEnum
     */
    @Test
    void validarSizeMotivoBajaEnum() {
        // Arrange
        var motivosBajaEsperado = MotivoBajaEnum.values();

        // Act
        var motivosBajaDto = MotivoBajaEnumDto.values();

        // Assert
        assertEquals(motivosBajaEsperado.length, motivosBajaDto.length, "El tamaño de los enums de los Motivos de Baja no es el mismo");
    }

    /**
     * Validar que los valores de MotivoBajaEnumDto
     * sean iguales a los de MotivoBajaEnum
     */
    @Test
    void validarValoresMotivoBajaEnum() {
        // Arrange
        var motivosBajaEsperados = Arrays.stream(GeneroEnum.values()).map(GeneroEnum::name).collect(Collectors.toSet());
        var motivosBajaDto = Arrays.stream(GeneroEnumDto.values()).map(GeneroEnumDto::name).collect(Collectors.toSet());

        // Act
            // Validar que los valores de MotivoBajaEnumDto estén en MotivoBajaEnum
        boolean motivosBajaDtoInMotivoBaja = motivosBajaEsperados.containsAll(motivosBajaDto);
            // Validar que los valores de MotivoBajaEnum estén en MotivoBajaEnumDto
        boolean motivosBajaInMotivoBajaDto = motivosBajaDto.containsAll(motivosBajaEsperados);

        // Assert
        assertTrue(motivosBajaDtoInMotivoBaja, "Hay valores en MotivoBajaEnumDto que no están en MotivoBajaEnum");
        assertTrue(motivosBajaInMotivoBajaDto, "Hay valores en MotivoBajaEnum que no están en MotivoBajaEnumDto");
    }

}
