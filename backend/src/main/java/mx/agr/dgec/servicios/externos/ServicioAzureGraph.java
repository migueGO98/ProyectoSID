package mx.agr.dgec.servicios.externos;

import com.microsoft.graph.models.*;
import com.microsoft.graph.serviceclient.GraphServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Empleado;
import mx.agr.dgec.entidades.Rol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Este servicio sirve como CRUD de usuarios en Azure AD B2C
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioAzureGraph {

    private final GraphServiceClient graphClient;

    @Value("${azure.ad.b2c.tenant}")
    private String tenantId;

    /*
    * La documentacion de Azure B2C con Graph, indica que para agregar un atributo personalizado (claims) a un usuario,
    * se debe agregar un prefijo 'extension_' seguido de un GUID que se obtiene de la aplicacion de extensiones
    * */
    private static final String EXTENSION_CLIENT_ID = "extension_2d2c645787b3430e9749c9546ace41d4_";



    public void crearUsuario(Empleado empleado) {
        var nuevoUsuario = new User();

        nuevoUsuario.setAccountEnabled(empleado.getActivo());
        nuevoUsuario.setDisplayName(empleado.getNombreCompleto());
        nuevoUsuario.setMail(empleado.getCorreoElectronico());
        nuevoUsuario.setCreationType("LocalAccount");
        nuevoUsuario.setUserType("Member");
        nuevoUsuario.setGivenName(empleado.getNombre());
        nuevoUsuario.setSurname(empleado.concatenarApellidos());

        ObjectIdentity identidad = new ObjectIdentity();
        identidad.setIssuer(tenantId);
        identidad.setSignInType("emailAddress");
        identidad.setIssuerAssignedId(empleado.getCorreoElectronico());
        nuevoUsuario.setIdentities(List.of(identidad));

        PasswordProfile passwordUsuario = new PasswordProfile();
        passwordUsuario.setPassword(generarPassword());
        passwordUsuario.setForceChangePasswordNextSignIn(false); // El usuario debe cambiar la contraseña en el siguiente inicio de sesión
        nuevoUsuario.setPasswordProfile(passwordUsuario);
        nuevoUsuario.setPasswordPolicies("DisablePasswordExpiration");

        // Extension Client Id es el proyecto 'b2c-extensions-app. Do not modify. Used by AADB2C for storing user data.'
        // Validar que en el portal de azure - Atributos de usuarios, Existan los atributos que se mencionan (idEmpleado, nombreCompleto, etc...)
        Map<String, Object> additionalData = Map.of(
                EXTENSION_CLIENT_ID + "idEmpleado", empleado.getIdEmpleado(),
                EXTENSION_CLIENT_ID + "nombreCompleto", empleado.getNombreCompleto(),
                EXTENSION_CLIENT_ID + "activo", empleado.getActivo(),
                EXTENSION_CLIENT_ID + "fechaIngreso", empleado.getFechaIngreso(),
                EXTENSION_CLIENT_ID + "idTipoPlaza", empleado.getTipoPlaza().getIdTipoPlaza(),
                EXTENSION_CLIENT_ID + "idRegion", empleado.getRegion().getIdRegion(),
                EXTENSION_CLIENT_ID + "idDireccion", empleado.getDireccion().getIdDireccion(),
                EXTENSION_CLIENT_ID + "idSubdireccion", empleado.getSubdireccion().getIdSubdireccion(),
                EXTENSION_CLIENT_ID + "idPuesto", empleado.getPuesto().getIdPuesto(),
                EXTENSION_CLIENT_ID + "idRoles", recuperarIdRoldeEntidadRol(empleado.getRoles())
        );
        nuevoUsuario.setAdditionalData(additionalData);

        graphClient.users().post(nuevoUsuario);
        log.info("Usuario creado: {} en Azure AD B2C con idEmpleado {}", empleado.getNombreCompleto().toUpperCase(), empleado.getIdEmpleado());
    }


    public void listUsers() {
        var respuesta = requireNonNull(graphClient.users().get(), "La respuesta es null para obtener usuarios");
        var usuarios = requireNonNull(respuesta.getValue(), "La lista de usuarios es null");
        if (usuarios.isEmpty()) {
            log.info("No hay usuarios registrados en Azure AD B2C, la lista está vacía");
            return;
        }
        usuarios.forEach(usuario -> log.info("User: {}", usuario.getUserType()));
    }

    // Genera una contraseña temporal para el usuario, la contraseña es "Temporal" + ultimos 2 digitos del año actual
    private String generarPassword() {
        return "Temporal" + String.valueOf(java.time.LocalDate.now().getYear()).substring(2);
    }

    private String recuperarIdRoldeEntidadRol(Set<Rol> roles) {
        var rolesList = roles.stream().map(Rol::getIdRol).toList();
        return String.join(",", rolesList);
    }
}
