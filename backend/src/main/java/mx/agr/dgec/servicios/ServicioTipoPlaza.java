package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.mappers.TipoPlazaMapper;
import mx.agr.dgec.repositorios.RepositorioTipoPlaza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServicioTipoPlaza {

    @Autowired
    RepositorioTipoPlaza repositorioTipoPlaza;

    public List<RegistrosDto> recuperarTiposPlazas() {
        var tiposPlazas = repositorioTipoPlaza.findAll();
        log.info("Se recuperaron los tipos de plazas");
        return TipoPlazaMapper.INSTANCE.tipoPlazasToRegistrosDto(tiposPlazas);
    }
}
