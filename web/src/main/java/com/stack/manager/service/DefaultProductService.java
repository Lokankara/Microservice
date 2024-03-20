package com.stack.manager.service;

import com.stack.manager.dao.ProductDao;
import com.stack.manager.model.Product;
import com.stack.manager.model.PostProductPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService
        implements ProductService {

    private final ProductDao dao;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product create(PostProductPayload payload) {
        Product product = new Product(
                0,
                payload.url(), payload.price(),
                payload.title(), payload.details());
        return this.dao.save(product);
    }

    @Override
    public Optional<Product> findById(int productId) {
        return dao.findById(productId);
    }

    @Override
    public void updateProduct(int productId, PostProductPayload payload) {
        this.dao.findById(productId).ifPresentOrElse(
                product -> {
                    product.setTitle(payload.title());
                    product.setDetails(payload.details());
                }, () -> {
                    throw new NoSuchElementException();
                }
        );
    }

    @Override
    public void deleteProduct(int id) {
        dao.deleteById(id);
    }
}
