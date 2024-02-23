package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.enums.GenerosEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String curp;
    private String rfc;
    private String numeroSeguroSocial;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;

    private int edad;
    private GenerosEnum genero;
    private String telefonoPersonal;
    private String correoElectronicoPersonal;
    private EstadoCivilEnum estadoCivil;
    private Boolean hijos;
    private String contactoEmergenciaNombre;
    private String contactoEmergenciaTelefono;
    private Domicilio domicilio;
    private List<Escolaridad> escolaridades;
}
