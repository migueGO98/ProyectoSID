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
    private String idPersona;
    private String calle;
    private String codigoPostal;
    private String colonia;
    private String municipio;
    private String ciudad;
    private String estado;

    @MapsId(value = "idPersona")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona", nullable = false, foreignKey = @ForeignKey(name = "FK_DOMICILIO_PERSONA"))
    private Persona persona;
}
