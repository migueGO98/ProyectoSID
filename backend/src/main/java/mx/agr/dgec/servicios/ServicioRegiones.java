package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Direccion;
import mx.agr.dgec.entidades.Region;
import mx.agr.dgec.exceptions.ElementoNoEncontradoException;
import mx.agr.dgec.exceptions.ElementoNoPerteneceException;
import mx.agr.dgec.generate.model.DireccionDto;
import mx.agr.dgec.generate.model.RegionDto;
import mx.agr.dgec.mappers.RegionMapper;
import mx.agr.dgec.repositorios.RepositorioRegion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioRegiones {

    private final ServicioDirecciones servicioDirecciones;
    private final RepositorioRegion repositorioRegion;

    public List<RegionDto> recuperarRegiones() {
        var regiones = repositorioRegion.findAll();
        return RegionMapper.INSTANCE.listRegionesToListRegionesDto(regiones);
    }

    public List<DireccionDto> recuperarDireccionesByRegion(String idRegion) {
        var region = obtenerRegion(idRegion);
        var direcciones = region.getDirecciones();
        log.info("Se recuperaron las direcciones de la región con ID {}", idRegion.toUpperCase());
        return servicioDirecciones.mapearDireccionesToDireccionesDto(direcciones);
    }

    public Region obtenerRegion(String idRegion) {
        final var region = repositorioRegion.findById(idRegion.toUpperCase());
        if (region.isEmpty()) throw new ElementoNoEncontradoException("No existe la Región con el id proporcionado " + idRegion.toUpperCase());
        return region.get();
    }

    public void validarDireccionPertenezcaToRegion(Region region, Direccion direccion) {
        if(!direccion.getRegion().equals(region))
            throw new ElementoNoPerteneceException("La Dirección no pertenece a la Región");
    }
}
