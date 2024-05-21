package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Puesto;
import mx.agr.dgec.entidades.TipoPlaza;
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
        if(idTipoPlazaValue.isBlank()) throw new IllegalArgumentException("El idTipoPlaza no puede estar vacío");
        var tipoPlaza = repositorioTipoPlaza.findById(idTipoPlazaValue.toUpperCase());
        if (tipoPlaza.isEmpty()) throw new IllegalArgumentException("El idTipoPlaza no es válido o es inexistente");
        return tipoPlaza.get();
    }

    // Valida que el puesto pertenezca al tipo de plaza
    public void validarPuestoPertenezcaToTipoPlaza(TipoPlaza tipoPlaza, Puesto puesto) {
        if(!puesto.getTipoPlaza().equals(tipoPlaza))
            throw new IllegalArgumentException("El puesto no pertenece al tipo de plaza");
    }
}
