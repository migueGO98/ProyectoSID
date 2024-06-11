package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Direccion;
import mx.agr.dgec.entidades.Region;
import mx.agr.dgec.exceptions.ElementoNoPerteneceException;
import mx.agr.dgec.repositorios.RepositorioRegion;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioRegiones {

    private final RepositorioRegion repositorioRegion;

    public Region obtenerRegion(String regionValue) {
        final var region = repositorioRegion.findById(regionValue.toUpperCase());
        if (region.isEmpty()) throw new IllegalArgumentException("No existe la Región con el id proporcionado");
        return region.get();
    }

    // Valida que la Dirección pertenezca  la Region
    public void validarDireccionPertenezcaToRegion(Region region, Direccion direccion) {
        if(!direccion.getRegion().equals(region))
            throw new ElementoNoPerteneceException("La Dirección no pertenece a la Región");
    }
}
