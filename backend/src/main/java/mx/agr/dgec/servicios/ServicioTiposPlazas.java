package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.TipoPlaza;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.mappers.TipoPlazaMapper;
import mx.agr.dgec.repositorios.RepositorioTipoPlaza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServicioTiposPlazas {

    @Autowired
    RepositorioTipoPlaza repositorioTipoPlaza;

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
}
