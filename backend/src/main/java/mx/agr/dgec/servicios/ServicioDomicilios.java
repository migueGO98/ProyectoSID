package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.generate.model.DomicilioDto;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServicioDomicilios {

    public void validarDomicilioDto(DomicilioDto domicilioDto) {
        if (domicilioDto.getCalle().isBlank()) throw new IllegalArgumentException("La calle no puede ser nula o vacía");
        if (domicilioDto.getColonia().isBlank()) throw new IllegalArgumentException("La colonia no puede ser nula o vacía");
        if (domicilioDto.getCodigoPostal().isBlank()) throw new IllegalArgumentException("El código postal no puede ser nulo o vacío");
        if (domicilioDto.getMunicipio().isBlank()) throw new IllegalArgumentException("El municipio no puede ser nulo o vacío");
        if (domicilioDto.getCiudad().isBlank()) throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
        if (domicilioDto.getEstado().isBlank()) throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
    }
}
