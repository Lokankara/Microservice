package com.stack.catalogue.service;

import com.stack.catalogue.dao.ProductDao;
import com.stack.catalogue.model.BaseDto;
import com.stack.catalogue.model.PostProductPayload;
import com.stack.catalogue.model.Product;
import com.stack.catalogue.model.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InMemoryProductService
        implements ProductService {

    private final ProductDao dao;

    @Override
    public List<Product> findAllProducts(String filter,
                                         int page,
                                         int size) {
        return dao.findAll();
    }

    @Override
    public ResponseEntity<BaseDto> createProduct(
            PostProductPayload payload,
            UriComponentsBuilder builder) {
        Product product = new Product(0,
                                      payload.url(),
                                      payload.price(),
                                      payload.title(),
                                      payload.details());
        return ResponseEntity.ok().body(
                productToDto(this.dao.save(product)));
    }

    @Override
    public Optional<Product> findProductById(int productId) {
        return dao.findById(productId);
    }

    @Override
    public ProductResponseDto updateProduct(
            Integer id,
            PostProductPayload payload) {
        return productToDto(this.dao.findById(id)
                                    .map(existingProduct -> {
                                        existingProduct.setTitle(payload.title());
                                        existingProduct.setDetails(payload.details());
                                        existingProduct.setUrl(payload.url());
                                        existingProduct.setPrice(payload.price());
                                        return existingProduct;
                                    })
                                    .orElseThrow(NoSuchElementException::new));
    }

    @Override
    public void deleteProduct(Integer id) {
        dao.deleteById(id);
    }
}
