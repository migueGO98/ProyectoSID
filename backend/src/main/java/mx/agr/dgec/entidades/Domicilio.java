package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio {

    @Id
    @Column(length = 30)
    private String idPersona;
    private String calle;
    @Column(length = 5)
    private String codigoPostal;
    @Column(length = 150)
    private String colonia;
    @Column(length = 150)
    private String municipio;
    @Column(length = 150)
    private String ciudad;
    @Column(length = 50)
    private String estado;

    @MapsId(value = "idPersona")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona", nullable = false, foreignKey = @ForeignKey(name = "FK_DOMICILIO_PERSONA"))
    @ToString.Exclude
    private Persona persona;
}
