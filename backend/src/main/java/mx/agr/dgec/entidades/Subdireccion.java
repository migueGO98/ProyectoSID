package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subdireccion {

    @Id
    @Column(length = 30)
    private String idSubdireccion;
    private String nombre;

    @OneToMany(mappedBy = "subdireccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Empleado> empleados;

    @ManyToOne
    @JoinColumn(name = "idDireccion", referencedColumnName = "idDireccion", nullable = false, foreignKey = @ForeignKey(name = "FK_Subdireccion_Direccion"))
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = false, foreignKey = @ForeignKey(name = "FK_Subdireccion_Estado"))
    private Estado estado;
}
