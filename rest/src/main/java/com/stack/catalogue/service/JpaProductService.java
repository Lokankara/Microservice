package com.stack.catalogue.service;

import com.stack.catalogue.dao.ProductRepository;
import com.stack.catalogue.model.PostProductPayload;
import com.stack.catalogue.model.Product;
import com.stack.catalogue.model.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Iterable<Product> findAllProducts(String filter) {
        if (filter != null && !filter.isBlank()) {
            return this.productRepository.findAllByTitleLikeIgnoreCase("%" + filter + "%");
        } else {
            return this.productRepository.findAll();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<ProductResponseDto> createProduct(
            PostProductPayload payload,
            UriComponentsBuilder builder) {
        ProductResponseDto dto = productToDto(this.productRepository.save(toEntity(payload)));
        return ResponseEntity.created(builder.replacePath("/catalogue-api/products/{productId}")
                       .build(Map.of("productId", dto.getId()))).body(dto);
    }



    @Override
    public Optional<Product> findProductById(int productId) {
        return this.productRepository.findById(productId);
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(
            Integer id,
            PostProductPayload payload) {
        return productToDto(this.productRepository.findById(id)
                                          .map(product -> {
                                              product.setTitle(payload.title());
                                              product.setDetails(payload.details());
                                              return product;
                                          }).orElseThrow(NoSuchElementException::new));
    }

    private ProductResponseDto productToDto(Product product) {
        return ProductResponseDto.builder()
                                 .id(product.getId())
                                 .title(product.getTitle())
                                 .price(product.getPrice())
                                 .details(product.getDetails())
                                 .url(product.getUrl())
                                 .build();
    }

    private Product toEntity(PostProductPayload payload) {
        return new Product(null, payload.url(), payload.price(), payload.title(), payload.details());
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
    }
}
