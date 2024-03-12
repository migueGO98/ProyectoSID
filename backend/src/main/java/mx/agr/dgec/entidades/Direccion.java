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
public class Direccion {

    @Id
    @Column(length = 30)
    private String idDireccion;
    private String nombre;

    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    @ManyToOne
    @JoinColumn(name = "idRegion", referencedColumnName = "idRegion", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_Direccion_Region"))
    private Region region;

    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_Direccion_Estado"))
    private Estado estado;

    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subdireccion> subdireccions;

}
