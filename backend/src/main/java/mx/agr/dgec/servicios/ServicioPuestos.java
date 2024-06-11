package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Puesto;
import mx.agr.dgec.exceptions.ElementoNoEncontradoException;
import mx.agr.dgec.repositorios.RepositorioPuesto;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioPuestos {

    private final RepositorioPuesto repositorioPuesto;

    public Puesto obtenerPuesto(String idPuestoValue) {
        final var puesto = repositorioPuesto.findById(idPuestoValue.toUpperCase());
        if (puesto.isEmpty()) throw new ElementoNoEncontradoException("No existe el Puesto con el id proporcionado");
        return puesto.get();
    }
}
