package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.*;
import mx.agr.dgec.entidades.primary_key.EscolaridadPK;
import mx.agr.dgec.enums.EstadosNivelesEscolaridadesEnum;
import mx.agr.dgec.enums.NivelesEscolaridadesEnum;

@Entity
@IdClass(value = EscolaridadPK.class)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escolaridad {

    @Id
    @Column(length = 30)
    private String idPersona;
    @Id
    @Enumerated(EnumType.STRING)
    private NivelesEscolaridadesEnum nivel;
    @Id
    private String carrera;
    @Enumerated(EnumType.STRING)
    private EstadosNivelesEscolaridadesEnum estadoNivel;
    @Column(length = 10)
    private String cedulaProfesional;

    @MapsId(value = "idPersona")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "FK_ESCOLARIDAD_PERSONA"))
    @ToString.Exclude
    private Persona persona;
}
