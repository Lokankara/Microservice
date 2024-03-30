package com.stack.catalogue.service;

import com.stack.catalogue.dao.ProductRepository;
import com.stack.catalogue.model.BaseDto;
import com.stack.catalogue.model.PostProductPayload;
import com.stack.catalogue.model.Product;
import com.stack.catalogue.model.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private final ProductRepository repository;

    @Override
    public Iterable<Product> findAllProducts(String filter, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (filter != null && !filter.isEmpty()) {
            return repository.findByTitleContaining(filter, pageable).getContent();
        } else {
            return repository.findAll(pageable).getContent();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<BaseDto> createProduct(
            PostProductPayload payload,
            UriComponentsBuilder builder) {
        ProductResponseDto dto = productToDto(this.repository.save(toEntity(payload)));
        return ResponseEntity.created(builder.replacePath("/catalogue-api/products/{productId}")
                       .build(Map.of("productId", dto.getId()))).body(dto);
    }



    @Override
    public Optional<Product> findProductById(int productId) {
        return this.repository.findById(productId);
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(
            Integer id,
            PostProductPayload payload) {
        return productToDto(this.repository.findById(id)
                                           .map(product -> {
                                              product.setTitle(payload.title());
                                              product.setDetails(payload.details());
                                              return product;
                                          }).orElseThrow(NoSuchElementException::new));
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        this.repository.deleteById(id);
    }
}
