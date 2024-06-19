package mx.agr.dgec.seguridad;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        if( authException instanceof AuthenticationCredentialsNotFoundException )
            throw new AuthenticationCredentialsNotFoundException("Authentication required: " + authException.getMessage());

        if( authException instanceof CredentialsExpiredException) {
            throw new CredentialsExpiredException("Credentials Expired: " + authException.getMessage());
        }
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        throw new AccessDeniedException("Access Denied: " + accessDeniedException.getMessage());
    }

}
