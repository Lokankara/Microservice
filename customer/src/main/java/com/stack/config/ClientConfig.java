package com.stack.config;

import com.stack.client.ProductClient;
import com.stack.client.WebClientProductClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

    @Bean
    public ProductClient webClientProductClient(
            @Value("shop.service.catalogue.uri:http://localhost:8081") String baseUrl) {
        return new WebClientProductClient(
                WebClient.builder()
                         .baseUrl(baseUrl)
                         .build());
    }
}
