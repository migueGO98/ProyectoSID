package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Direccion;
import mx.agr.dgec.entidades.Region;
import mx.agr.dgec.repositorios.RepositorioRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServicioRegiones {

    @Autowired
    RepositorioRegion repositorioRegion;

    public Region obtenerRegion(String regionValue) {
        if(regionValue.isBlank()) throw new IllegalArgumentException("El idRegión no puede estar vacío");
        var region = repositorioRegion.findById(regionValue.toUpperCase());
        if (region.isEmpty()) throw new IllegalArgumentException("El idRegión no es válido o es inexistente");
        return region.get();
    }

    // Valida que la Dirección pertenezca  la Region
    public void validarDireccionPertenezcaToRegion(Region region, Direccion direccion) {
        if(!direccion.getRegion().equals(region))
            throw new IllegalArgumentException("La Dirección no pertenece a la Región");
    }
}
