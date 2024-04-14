package com.stack.catalogue.service;

import com.stack.catalogue.model.dto.BaseDto;
import com.stack.catalogue.model.dto.PostProductPayload;
import com.stack.catalogue.model.entity.Product;
import com.stack.catalogue.model.dto.ProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts(String filter, int page, int size);

    ResponseEntity<BaseDto> createProduct(
            PostProductPayload payload, UriComponentsBuilder builder);

    Optional<Product> findProductById(int productId);

    ProductResponseDto updateProduct(Integer id, PostProductPayload payload);

    void deleteProduct(Integer id);

    default ProductResponseDto productToDto(
            Product product) {
        return ProductResponseDto.builder()
                                 .id(product.getId())
                                 .title(product.getTitle())
                                 .price(product.getPrice())
                                 .details(product.getDetails())
                                 .url(product.getUrl())
                                 .build();
    }

    default Product toEntity(
            PostProductPayload payload) {
        return new Product(
                null,
                payload.url(),
                payload.price(),
                payload.title(),
                payload.details());
    }
}
