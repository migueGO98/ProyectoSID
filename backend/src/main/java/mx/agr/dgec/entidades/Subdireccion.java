package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subdireccion {

    @Id
    private String idSubdireccion;
    private String nombre;

    @OneToMany(mappedBy = "subdireccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    @ManyToOne
    @JoinColumn(name = "idDireccion", referencedColumnName = "idDireccion", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_Subdireccion_Direccion"))
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_Subdireccion_Estado"))
    private Estado estado;
}
