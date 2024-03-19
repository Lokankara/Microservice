package com.stack.catalogue.service;

import com.stack.catalogue.model.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts(String filter);

    Product createProduct(
            String title,
            String details);

    Optional<Product> findProduct(int productId);

    void updateProduct(
            Integer id,
            String title,
            String details);

    void deleteProduct(Integer id);
}
