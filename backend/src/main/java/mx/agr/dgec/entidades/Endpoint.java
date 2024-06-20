package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.*;
import mx.agr.dgec.entidades.primary_key.EndpointPK;
import mx.agr.dgec.enums.MetodosHttpEnum;

import java.util.Set;

@Entity
@IdClass(value = EndpointPK.class)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endpoint {
    @Id
    @Enumerated(EnumType.STRING)
    private MetodosHttpEnum metodoHttp;
    @Id
    private String rutaEndpoint;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "EndpointsRoles",
            joinColumns = {
                    @JoinColumn(name = "metodoHttp", referencedColumnName = "metodoHttp", foreignKey = @ForeignKey(name = "FK_EndpointsMetodo_Roles")),
                    @JoinColumn(name = "rutaEndpoint", referencedColumnName = "rutaEndpoint", foreignKey = @ForeignKey(name = "FK_EndpointsRuta_Roles")),
            },
            inverseJoinColumns = @JoinColumn(name = "idRol", referencedColumnName = "idRol", foreignKey = @ForeignKey(name = "FK_Roles_Endpoints"))
    )
    private Set<Rol> roles;

}
