package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.*;
import mx.agr.dgec.enums.MetodosHttpEnum;

import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEndpoint;
    @Enumerated(EnumType.STRING)
    private MetodosHttpEnum metodoHttp;
    private String rutaEndpoint;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "EndpointsRoles",
            joinColumns = @JoinColumn(name = "idEndpoint", referencedColumnName = "idEndpoint", foreignKey = @ForeignKey(name = "FK_Endpoints_Roles")),
            inverseJoinColumns = @JoinColumn(name = "idRol", referencedColumnName = "idRol", foreignKey = @ForeignKey(name = "FK_Roles_Endpoints"))
    )
    private Set<Rol> roles;

}
