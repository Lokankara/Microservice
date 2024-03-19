package com.stack.manager.service;

import com.stack.manager.dao.ProductDao;
import com.stack.manager.model.Product;
import com.stack.manager.model.ProductPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Product create(ProductPayload payload) {
        return this.dao.save(new Product( 0, payload.title(), payload.details()));
    }

    @Override
    public Optional<Product> findById(int productId) {
        return dao.findById(productId);
    }
}
