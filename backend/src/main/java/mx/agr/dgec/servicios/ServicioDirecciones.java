package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Direccion;
import mx.agr.dgec.entidades.Subdireccion;
import mx.agr.dgec.exceptions.ElementoNoEncontradoException;
import mx.agr.dgec.exceptions.ElementoNoPerteneceException;
import mx.agr.dgec.repositorios.RepositorioDireccion;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioDirecciones {

    private final RepositorioDireccion repositorioDirecciones;

    public Direccion obtenerDireccion(String direccionValue) {
        final var direccion = repositorioDirecciones.findById(direccionValue.toUpperCase());
        if (direccion.isEmpty()) throw new ElementoNoEncontradoException("No existe la Dirección con el id proporcionado");
        return direccion.get();
    }

    // Valida que la Subdirección pertenezca a la Dirección
    public void validarSubdireccionPertenezcaToDireccion(Direccion direccion, Subdireccion subdireccion) {
        if(!subdireccion.getDireccion().equals(direccion))
            throw new ElementoNoPerteneceException("La Subdirección no pertenece a la Dirección");
    }

}
