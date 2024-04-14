package com.stack.catalogue.dao;

import com.stack.catalogue.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(int productId);

    void deleteById(int id);
}
