package mx.agr.dgec.config;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.serviceclient.GraphServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureGraph {
    @Value("${azure.ad.b2c.client-id}")
    private String CLIENT_ID;

    @Value("${azure.ad.b2c.client-secret}")
    private String CLIENT_SECRET;

    @Value("${azure.ad.b2c.tenant}")
    private String TENANT_ID;

    @Bean
    public GraphServiceClient graphClient() {
        var credential = new ClientSecretCredentialBuilder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .tenantId(TENANT_ID)
                .build();
        return new GraphServiceClient(credential);
    }
}
