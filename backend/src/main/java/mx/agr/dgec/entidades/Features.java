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
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFeature;
    @Enumerated(EnumType.STRING)
    private MetodosHttpEnum metodoHttp;
    private String endpoint;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "FeaturesRoles",
            joinColumns = @JoinColumn(name = "idFeature", referencedColumnName = "idFeature", foreignKey = @ForeignKey(name = "FK_Feature_Roles")),
            inverseJoinColumns = @JoinColumn(name = "idRol", referencedColumnName = "idRol", foreignKey = @ForeignKey(name = "FK_Roles_Feature"))
    )
    private Set<Rol> roles;

}
