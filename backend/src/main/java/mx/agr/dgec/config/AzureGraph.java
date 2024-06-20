package mx.agr.dgec.config;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.serviceclient.GraphServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureGraph {
    @Value("${azure.ad.b2c.client-id}")
    private String cliendId;

    @Value("${azure.ad.b2c.client-secret}")
    private String clientSecret;

    @Value("${azure.ad.b2c.tenant}")
    private String tenantId;

    @Bean
    public GraphServiceClient graphClient() {
        var credential = new ClientSecretCredentialBuilder()
                .clientId(cliendId)
                .clientSecret(clientSecret)
                .tenantId(tenantId)
                .build();
        return new GraphServiceClient(credential);
    }
}
