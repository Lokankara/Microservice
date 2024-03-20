package com.stack.catalogue.service;

import com.stack.catalogue.model.PostProductPayload;
import com.stack.catalogue.model.Product;
import com.stack.catalogue.model.ProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts(String filter);

    ResponseEntity<ProductResponseDto> createProduct(PostProductPayload payload, UriComponentsBuilder builder);

    Optional<Product> findProductById(int productId);

    ProductResponseDto updateProduct(Integer id, PostProductPayload payload);

    void deleteProduct(Integer id);
}
