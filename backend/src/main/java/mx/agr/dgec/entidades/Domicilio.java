package mx.agr.dgec.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona", nullable = false, foreignKey = @ForeignKey(name = "FK_DOMICILIO_PERSONA"))
    private Persona persona;
}
