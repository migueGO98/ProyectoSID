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
public class Estado {

    @Id
    private String idEstado;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idRegion", referencedColumnName = "idRegion", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_Estado_Region"))
    private Region region;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subdireccion> subdirecciones;
}
