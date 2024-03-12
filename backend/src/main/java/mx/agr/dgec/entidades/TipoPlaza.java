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
public class TipoPlaza {

    @Id
    @Column(length = 30)
    private String idTipoPlaza;
    private String nombre;

    @OneToMany(mappedBy = "tipoPlaza", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "tipoPlaza", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Puesto> puestos;
}
