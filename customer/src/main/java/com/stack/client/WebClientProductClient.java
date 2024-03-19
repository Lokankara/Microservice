package com.stack.client;

import com.stack.customer.Product;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class WebClientProductClient
        implements ProductClient {

    private final WebClient webClient;

    @Override
    public Flux<Product> findAllProducts(String filter) {
        return this.webClient.get()
                             .uri("/catalogue-api/products?filter={filter}", filter)
                             .retrieve()
                             .bodyToFlux(Product.class);
    }
}
