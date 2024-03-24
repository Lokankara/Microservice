package com.stack.manager.client;

import com.stack.manager.model.PostProductPayload;
import com.stack.manager.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductClient {
    Optional<Product> findById(int productId);

    void deleteProduct(int id);

    void updateProduct(int id, PostProductPayload payload);

    List<Product> findAll();

    Product create(PostProductPayload payload);
}
