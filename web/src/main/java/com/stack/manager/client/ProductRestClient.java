package com.stack.manager.client;

import com.stack.manager.exception.BadRequestException;
import com.stack.manager.model.PostProductPayload;
import com.stack.manager.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductRestClient
        implements ProductClient{

    private final RestClient restClient;
    private static final String BASE_URL = "/catalogue-api/products";

    private static final ParameterizedTypeReference<List<Product>>
            PRODUCTS_TYPE_REFERENCE = new ParameterizedTypeReference<>() {};

    @Override
    public Optional<Product> findById(int productId) {
        try{
            return Optional.ofNullable(getBody(productId));
        } catch (HttpClientErrorException.NotFound exception){
            return Optional.empty();
        }
    }

    private Product getBody(int productId) {
        return this.restClient.get()
                              .uri(BASE_URL + "/" + productId)
                              .retrieve()
                              .body(Product.class);
    }

    @Override
    public void deleteProduct(int id) {
        try {
            this.restClient.delete()
                           .uri(BASE_URL)
                           .retrieve()
                           .toBodilessEntity();
        } catch (HttpClientErrorException.NotFound exception){
            throw new NoSuchElementException(exception);
        }
    }

    @Override
    public void updateProduct(
            int id,
            PostProductPayload payload) {
        try {
            this.restClient.patch()
                                  .uri(BASE_URL+"/{productId}", id)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .body(payload)
                                  .retrieve()
                                  .toBodilessEntity();
        } catch (HttpClientErrorException.BadRequest exception){
            throw new BadRequestException(Collections.singletonList(exception.getMessage()));
        }
    }

    @Override
    public List<Product> findAll() {
        return this.restClient
                .get()
                .uri(BASE_URL)
                .retrieve().body(PRODUCTS_TYPE_REFERENCE);
    }

    @Override
    public Product create(PostProductPayload payload) {
        try {
            return this.restClient.post()
                                  .uri(BASE_URL)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .body(payload)
                                  .retrieve()
                                  .body(Product.class);
        } catch (HttpClientErrorException.BadRequest exception){
            throw new BadRequestException(Collections.singletonList(exception.getMessage()));
        }
    }
}
