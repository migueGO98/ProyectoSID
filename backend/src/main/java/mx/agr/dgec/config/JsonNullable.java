package mx.agr.dgec.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JsonNullable {
    @Bean
    public JsonNullableModule jsonNullableModule() {
        return new JsonNullableModule();
    }

    @Bean
    public RestTemplate restTemplate(ObjectMapper objectMapper) {
        var converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        return new RestTemplateBuilder().additionalMessageConverters(converter).build();
    }

    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper) {
        return new ModelResolver(objectMapper);
    }
}
