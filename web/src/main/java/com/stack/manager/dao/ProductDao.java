package com.stack.manager.dao;

import com.stack.manager.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(int productId);
}
