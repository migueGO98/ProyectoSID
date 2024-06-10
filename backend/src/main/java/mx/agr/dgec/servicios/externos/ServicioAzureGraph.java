package mx.agr.dgec.servicios.externos;

import com.microsoft.graph.models.UserCollectionResponse;
import com.microsoft.graph.serviceclient.GraphServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

/**
 * Este servicio sirve como CRUD de usuarios en Azure AD B2C
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioAzureGraph {

    private final GraphServiceClient graphClient;

    public void listUsers() {
        var respuesta = requireNonNull(graphClient.users().get(), "La respuesta es null para obtener usuarios");
        var usuarios = requireNonNull(respuesta.getValue(), "La lista de usuarios es null");
        if (usuarios.isEmpty()) {
            log.info("No hay usuarios registrados en Azure AD B2C, la lista está vacía");
            return;
        }
        usuarios.forEach(usuario -> log.info("User: {}", usuario.getUserType()));
    }
}
