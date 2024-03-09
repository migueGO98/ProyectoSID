package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import mx.agr.dgec.enums.MotivoBajaEnum;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@SuperBuilder
public class Empleado extends Persona {
    private String idEmpleado;
    private Boolean activo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaIngreso;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaBaja;

    private String correoElectronico;
    private String telefono;
    private String extensionTelefono;
    private int diasVacacionesDisponibles;
    private int diasVacacionesTomados;
    private MotivoBajaEnum motivoBaja;
    private String idTipoPlaza;
    private String idPuesto;
    private String idRegion;
    private String idDireccion;
    private String idSubdireccion;
    private List<String> roles;

    public void calcularEdad() {
        super.calcularEdadPersona();
    }
}
