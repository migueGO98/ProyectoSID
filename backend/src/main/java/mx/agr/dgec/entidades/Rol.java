package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @Column(length = 30)
    private String idRol;
    private String descripcion;

    @ManyToMany(mappedBy = "roles")
    private Set<Empleado> empleados;
}
