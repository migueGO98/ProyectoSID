package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import mx.agr.dgec.entidades.interfaces.PersonaInterface;
import mx.agr.dgec.enums.MotivoBajaEnum;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "idEmpleado", referencedColumnName = "idPersona", foreignKey = @ForeignKey(name = "FK_EMPLEADO_PERSONA"))
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Empleado extends Persona implements PersonaInterface {

    @Column(insertable = false, updatable = false, length = 30)
    private String idEmpleado;
    private Boolean activo;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaIngreso;
    private String correoElectronico;
    @Column(length = 10)
    private String telefono;
    @Column(length = 10)
    private String extensionTelefono;
    private byte diasVacacionesDisponibles;
    private byte diasVacacionesTomados;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaBaja;
    @Enumerated(EnumType.STRING)
    private MotivoBajaEnum motivoBaja;

    @ManyToOne
    @JoinColumn(name = "idRegion", referencedColumnName = "idRegion", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLEADO_REGION"))
    private Region region;

    @ManyToOne
    @JoinColumn(name = "idDireccion", referencedColumnName = "idDireccion", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLEADO_DIRECCION"))
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "idSubdireccion", referencedColumnName = "idSubdireccion", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLEADO_SUBDIRECCION"))
    private Subdireccion subdireccion;

    @ManyToOne
    @JoinColumn(name = "idTipoPlaza", referencedColumnName = "idTipoPlaza", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLEADO_TIPO_PLAZA"))
    private TipoPlaza tipoPlaza;

    @ManyToOne
    @JoinColumn(name = "idPuesto", referencedColumnName = "idPuesto", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLEADO_PUESTO"))
    private Puesto puesto;

    @ManyToMany
    @JoinTable(
            name = "EmpleadosRoles",
            joinColumns = @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado", foreignKey = @ForeignKey(name = "FK_EMPLEADO_ROL")),
            inverseJoinColumns = @JoinColumn(name = "idRol", referencedColumnName = "idRol", foreignKey = @ForeignKey(name = "FK_ROL_EMPLEADO"))
    )
    private Set<Rol> roles;



    @Override
    public void calcularEdad() {
        super.calcularEdadPersona();
    }

    @Override
    public void formatearDatos() {
        correoElectronico = correoElectronico.trim();
        super.formatearDatosPersona();
    }

    @Override
    public void concatenarNombreAndApellidos() {
        super.concatenarNombreAndApellidosPersona();
    }

    @Override
    public String concatenarApellidos() {
        return super.concatenarApellidosPersona();
    }
}
