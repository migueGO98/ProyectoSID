package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Direccion;
import mx.agr.dgec.entidades.Subdireccion;
import mx.agr.dgec.repositorios.RepositorioDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServicioDirecciones {

    @Autowired
    RepositorioDireccion repositorioDirecciones;

    public Direccion obtenerDireccion(String direccionValue) {
        if(direccionValue.isBlank()) throw new IllegalArgumentException("El idDirección no puede estar vacío");
        var direccion = repositorioDirecciones.findById(direccionValue.toUpperCase());
        if (direccion.isEmpty()) throw new IllegalArgumentException("El idDirección no es válido o es inexistente");
        return direccion.get();
    }

    // Valida que la Subdirección pertenezca a la Dirección
    public void validarSubdireccionPertenezcaToDireccion(Direccion direccion, Subdireccion subdireccion) {
        if(!subdireccion.getDireccion().equals(direccion))
            throw new IllegalArgumentException("La Subdirección no pertenece a la Dirección");
    }

}
