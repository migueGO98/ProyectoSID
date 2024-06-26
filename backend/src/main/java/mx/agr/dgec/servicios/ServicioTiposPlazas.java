package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Puesto;
import mx.agr.dgec.entidades.TipoPlaza;
import mx.agr.dgec.exceptions.ElementoNoEncontradoException;
import mx.agr.dgec.exceptions.ElementoNoPerteneceException;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.mappers.TipoPlazaMapper;
import mx.agr.dgec.repositorios.RepositorioTipoPlaza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioTiposPlazas {

    private final RepositorioTipoPlaza repositorioTipoPlaza;

    public List<RegistrosDto> recuperarTiposPlazas() {
        var tiposPlazas = repositorioTipoPlaza.findAll();
        log.info("Se recuperaron los tipos de plazas");
        return TipoPlazaMapper.INSTANCE.tiposPlazasToRegistrosDto(tiposPlazas);
    }

    public TipoPlaza obtenerTipoPlaza(String idTipoPlazaValue) {
        var tipoPlaza = repositorioTipoPlaza.findById(idTipoPlazaValue.toUpperCase());
        if (tipoPlaza.isEmpty()) throw new ElementoNoEncontradoException("No existe el Tipo de Plaza con el id proporcionado");
        return tipoPlaza.get();
    }

    // Valida que el puesto pertenezca al tipo de plaza
    public void validarPuestoPertenezcaToTipoPlaza(TipoPlaza tipoPlaza, Puesto puesto) {
        if(!puesto.getTipoPlaza().equals(tipoPlaza))
            throw new ElementoNoPerteneceException("El puesto no pertenece al tipo de plaza");
    }
}
