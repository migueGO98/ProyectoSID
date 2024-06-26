package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.enums.GeneroEnum;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Persona {

    @Id
    @Column(length = 30)
    private String idPersona;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String apellidoPaterno;
    @Column(length = 50)
    private String apellidoMaterno;
    @Column(length = 150)
    private String nombreCompleto;
    @Column(length = 18)
    private String curp;
    @Column(length = 13)
    private String rfc;
    @Column(length = 11)
    private String numeroSeguroSocial;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;
    private byte edad;
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;
    @Column(length = 10)
    private String telefonoPersonal;
    private String correoElectronicoPersonal;
    @Enumerated(EnumType.STRING)
    private EstadoCivilEnum estadoCivil;
    private Boolean hijos;
    private String contactoEmergenciaNombre;
    @Column(length = 10)
    private String contactoEmergenciaTelefono;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "persona")
    @PrimaryKeyJoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "persona")
    @PrimaryKeyJoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private List<Escolaridad> escolaridades;



    protected final void calcularEdadPersona() {
        LocalDate fechaActual = LocalDate.now();
        this.edad = (byte) Period.between(fechaNacimiento, fechaActual).getYears();
    }

    protected final void formatearDatosPersona() {
        nombre = nombre.trim();
        apellidoPaterno = apellidoPaterno.trim();
        if(apellidoMaterno != null) apellidoMaterno = apellidoMaterno.trim();
        curp = curp.toUpperCase();
        rfc = rfc.toUpperCase();
        contactoEmergenciaNombre = contactoEmergenciaNombre.trim();
        escolaridades.forEach(Escolaridad::formatearCarrera);
    }

    protected final void concatenarNombreAndApellidosPersona() {
        nombreCompleto = (apellidoMaterno == null) ? String.format("%s %s", nombre, apellidoPaterno) : String.format("%s %s %s", nombre, apellidoPaterno, apellidoMaterno);
    }

    protected final String concatenarApellidosPersona() {
        return (apellidoMaterno == null) ? apellidoPaterno : String.format("%s %s", apellidoPaterno, apellidoMaterno);
    }
}
