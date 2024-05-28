package mx.agr.dgec.SID.servicios;

import mx.agr.dgec.entidades.Direccion;
import mx.agr.dgec.entidades.Region;
import mx.agr.dgec.repositorios.RepositorioDireccion;
import mx.agr.dgec.servicios.ServicioDirecciones;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServicioDireccionesTest {

    @Mock
    private RepositorioDireccion repositorioDireccion;

    @InjectMocks
    private ServicioDirecciones servicioDirecciones;

    Region region;
    Direccion direccion;

    @BeforeEach
    void setUp() {
        region = Region.builder().idRegion("R1").nombre("Región 1").build();
        direccion = Direccion.builder().idDireccion("R1").nombre("Región 1").build();
    }


    @Test
    void obtenerDireccion() {
        // Arrange


        // Act
        var direccion = servicioDirecciones.obtenerDireccion("DIRECCION");

        // Assert
    }

}
