package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Puesto;
import mx.agr.dgec.repositorios.RepositorioPuesto;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioPuestos {

    private final RepositorioPuesto repositorioPuesto;

    public Puesto obtenerPuesto(String idPuestoValue) {
        if(idPuestoValue.isBlank()) throw new IllegalArgumentException("El idPuesto no puede estar vacío");
        var puesto = repositorioPuesto.findById(idPuestoValue.toUpperCase());
        if (puesto.isEmpty()) throw new IllegalArgumentException("El idPuesto no es válido o es inexistente");
        return puesto.get();
    }
}
