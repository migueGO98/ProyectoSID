package mx.agr.dgec.SID.enums;

import mx.agr.dgec.enums.NivelesEscolaridadesEnum;
import mx.agr.dgec.generate.model.NivelesEscolaridadesEnumDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class NivelesEscolaridadesEnumTest {

    /**
     * Validar que el tamaño de NivelesEscolaridadesEnumDto
     * sea el mismo que NivelesEscolaridadesEnum
     */
    @Test
    void validarSizeNivelesEscolaridadesEnum() {
        // Arrange
        var nivelesEscolaridadesEsperado = NivelesEscolaridadesEnum.values();

        // Act
        var nivelesEscolaridadesDto = NivelesEscolaridadesEnumDto.values();

        // Assert
        assertEquals(nivelesEscolaridadesEsperado.length, nivelesEscolaridadesDto.length, "El tamaño de los enums de los Niveles de Escolaridades no es el mismo");
    }

    /**
     * Validar que los valores de NivelesEscolaridadesEnumDto
     * sean iguales a los de NivelesEscolaridadesEnum
     */
    @Test
    void validarValoresNivelesEscolaridadesEnum() {
        // Arrange
        var nivelesEscolaridadesEsperados = Arrays.stream(NivelesEscolaridadesEnum.values()).map(NivelesEscolaridadesEnum::name).collect(Collectors.toSet());
        var nivelesEscolaridadesDto = Arrays.stream(NivelesEscolaridadesEnumDto.values()).map(NivelesEscolaridadesEnumDto::name).collect(Collectors.toSet());

        // Act
            // Validar que los valores de NivelesEscolaridadesEnumDto estén en NivelesEscolaridadesEnum
        boolean nivelesEscolaridadesDtoInNivelesEscolaridades = nivelesEscolaridadesEsperados.containsAll(nivelesEscolaridadesDto);
            // Validar que los valores de NivelesEscolaridadesEnum estén en NivelesEscolaridadesEnumDto
        boolean nivelesEscolaridadesInNivelesEscolaridadesDto = nivelesEscolaridadesDto.containsAll(nivelesEscolaridadesEsperados);

        // Assert
        assertTrue(nivelesEscolaridadesInNivelesEscolaridadesDto, "Los valores de los enums de los Niveles de Escolaridades no son iguales");
        assertTrue(nivelesEscolaridadesDtoInNivelesEscolaridades, "Hay valores en NivelesEscolaridadesEnumDto que no están en NivelesEscolaridadesEnum");
    }
}
