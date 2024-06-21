package mx.agr.dgec.configs;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Sistema de Integración Divisional API",
                version = "1.0",
                description = "Proyecto personal de Miguel Guzman. \"Sistema de Integración Divisional\" para la empresa Agricultura en la Dirección General de Enlace y Coordinación (DGEC). Esta API está elaborada solo con fines educativos y de practica personal.",
                termsOfService = "http://example.com/terms",
                contact = @Contact(
                        name = "Soporte de API",
                        url = "http://example.com/contact",
                        email = "soporte@example.com"
                ),
                license = @License(
                        name = "Licencia MIT",
                        url = "http://opensource.org/licenses/MIT"
                )
        ),
        security = @SecurityRequirement(name = "bearerAuth"),
        externalDocs = @ExternalDocumentation(
                description = "Documentación externa para más detalles sobre la API",
                url = "https://github.com/springdoc/springdoc-openapi?tab=readme-ov-file"
        )
)
@SecurityScheme(
        name = "jwt",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SpringDoc {}
