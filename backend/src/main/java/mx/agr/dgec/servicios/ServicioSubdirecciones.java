package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Subdireccion;
import mx.agr.dgec.exceptions.ElementoNoEncontradoException;
import mx.agr.dgec.generate.model.SubdireccionDto;
import mx.agr.dgec.mappers.SubdireccionMapper;
import mx.agr.dgec.repositorios.RepositorioSubdireccion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioSubdirecciones {

    private final RepositorioSubdireccion repositorioSubdireccion;

    public Subdireccion obtenerSubdireccion(String idSubdireccion) {
        final var subdireccion = repositorioSubdireccion.findById(idSubdireccion.toUpperCase());
        if (subdireccion.isEmpty()) throw new ElementoNoEncontradoException("No existe la Subdirección con el id proporcionado: " + idSubdireccion.toUpperCase());
        return subdireccion.get();
    }

    public List<SubdireccionDto> mapSubdireccionesToSubdireccionesDto(List<Subdireccion> subDirecciones) {
        return SubdireccionMapper.INSTANCE.listSubdireccionesToListSubdireccionesDto(subDirecciones);
    }
}
