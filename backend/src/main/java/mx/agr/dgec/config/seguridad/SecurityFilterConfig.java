package mx.agr.dgec.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.seguridad.SecurityExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        jsr250Enabled = true
)
@RequiredArgsConstructor
@Slf4j
public class SecurityWeb {

    private final SecurityExceptionHandler securityExceptionHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(a -> a.jwtAuthenticationConverter(jwtAuthenticationConverter())))
                .csrf(AbstractHttpConfigurer::disable) // ¿Qué hace esta línea? porque permite que ingrese a la BD en memoria H2 https://stackoverflow.com/questions/43794721/spring-boot-h2-console-throws-403-with-spring-security-1-5-2
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))  // ¿Qué hace esta línea? porque permite que ingrese a la BD en memoria H2 https://stackoverflow.com/questions/43794721/spring-boot-h2-console-throws-403-with-spring-security-1-5-2
                .exceptionHandling(e -> e
                    .authenticationEntryPoint(securityExceptionHandler)
                    .accessDeniedHandler(securityExceptionHandler)
                )
                .build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            List<String> roles = jwt.getClaimAsStringList("extension_idRoles");
            var idEmpleado = jwt.getClaimAsString("extension_idEmpleado");

            log.info("Usuario con ID {} accediendo con roles: {}", idEmpleado, roles);

            return roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        });
        return converter;
    }

    /*
    private void authenticationEntryPoint(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ErrorDto errorDto = new ErrorDto(HttpStatus.UNAUTHORIZED.toString(), "No te encuentras autentificado");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getOutputStream().println(new ObjectMapper().writeValueAsString(errorDto));
    }

    private void accessDeniedHandler(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ErrorDto errorDto = new ErrorDto(HttpStatus.FORBIDDEN.toString(), "No tienes permiso para acceder a este recurso");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getOutputStream().println(new ObjectMapper().writeValueAsString(errorDto));
    }
    */

}
