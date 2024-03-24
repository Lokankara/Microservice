package com.stack.manager.config;

import com.stack.manager.client.ProductRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {
    @Bean
    public ProductRestClient productRestClient(
            @Value("${service.catalogue.uri:http://localhost:8081}") String uri
    ) {
        return new ProductRestClient(
                RestClient.builder()
                          .baseUrl(uri)
                          .build());
    }
}
