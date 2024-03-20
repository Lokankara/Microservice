package com.stack.manager.service;

import com.stack.manager.model.Product;
import com.stack.manager.model.PostProductPayload;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product create(PostProductPayload payload);

    Optional<Product> findById(int productId);

    void updateProduct(int productId, PostProductPayload payload);

    void deleteProduct(int id);
}
