package com.stack.manager.service;

import com.stack.manager.model.Product;
import com.stack.manager.model.ProductPayload;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product create(ProductPayload payload);

    Optional<Product> findById(int productId);
}
