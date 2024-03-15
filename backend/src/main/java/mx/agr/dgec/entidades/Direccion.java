package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    @Id
    @Column(length = 30)
    private String idDireccion;
    private String nombre;

    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Empleado> empleados;

    @ManyToOne
    @JoinColumn(name = "idRegion", referencedColumnName = "idRegion", nullable = false, foreignKey = @ForeignKey(name = "FK_Direccion_Region"))
    @ToString.Exclude
    private Region region;

    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = false, foreignKey = @ForeignKey(name = "FK_Direccion_Estado"))
    @ToString.Exclude
    private Estado estado;

    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Subdireccion> subdireccions;

}
