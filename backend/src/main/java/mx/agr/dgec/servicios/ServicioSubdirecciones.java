package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Subdireccion;
import mx.agr.dgec.repositorios.RepositorioSubdireccion;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioSubdirecciones {

    private final RepositorioSubdireccion repositorioSubdireccion;

    public Subdireccion obtenerSubdireccion(String idSubdireccionValue) {
        if(idSubdireccionValue.isBlank()) throw new IllegalArgumentException("El idSubdirección no puede estar vacío");
        var subdireccion = repositorioSubdireccion.findById(idSubdireccionValue.toUpperCase());
        if (subdireccion.isEmpty()) throw new IllegalArgumentException("El idSubdirección no es válido o es inexistente");
        return subdireccion.get();
    }
}
