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
public class Puesto {

    @Id
    private String idPuesto;
    private String nombre;
    private float salarioBruto;

    @ManyToOne
    @JoinColumn(name = "idTipoPlaza", referencedColumnName = "idTipoPlaza",nullable = false, foreignKey = @ForeignKey(name = "FK_PUESTO_TIPO_PLAZA"))
    private TipoPlaza tipoPlaza;

    @OneToMany(mappedBy = "puesto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> empleados;
}
