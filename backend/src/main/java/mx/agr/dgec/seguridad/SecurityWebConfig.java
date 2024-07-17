package mx.agr.dgec.seguridad;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collection;
import java.util.stream.Stream;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityWebConfig {

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
                ).cors(Customizer.withDefaults())
                .build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Collection<GrantedAuthority> authorities = defaultGrantedAuthoritiesConverter.convert(jwt);

            var roles = jwt.getClaimAsString("extension_idRoles");
            var idEmpleado = jwt.getClaimAsString("extension_idEmpleado");

            if (roles == null || roles.isEmpty()) {
                log.info("El empleado {} tiene lista de roles vacía o no tiene asignado el claim extension_idRoles", idEmpleado);
                return authorities;
            }
            authorities.addAll(
                    Stream.of(roles.split(","))
                            .map(role -> new SimpleGrantedAuthority(role.trim()))
                            .toList()
            );
            log.info("Permitiendo acceso al empleado {} con roles {}", idEmpleado, authorities);
            return authorities;
        });
        return jwtAuthenticationConverter;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*"); // Permitir cualquier origen
        corsConfiguration.addAllowedHeader("Content-Type"); // Permitir solo Content-Type y Authorization
        corsConfiguration.addAllowedHeader("Authorization");
        corsConfiguration.addAllowedMethod("*"); // Permitir cualquier método (GET, POST, etc.)
        corsConfiguration.setAllowCredentials(true); // Permitir credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }
}
