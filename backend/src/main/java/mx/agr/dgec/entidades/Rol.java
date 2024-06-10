package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.*;

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
    @ToString.Exclude
    private Set<Empleado> empleados;
}
