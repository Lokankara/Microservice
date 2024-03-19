package com.stack.manager.dao;

import com.stack.manager.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class InMemoryProductDao
        implements ProductDao {

    public InMemoryProductDao() {
        IntStream.range(1, 4)
                 .forEach(i -> this.products.add(
                         new Product(i, "Goods #%d".formatted(i),
                                     "Description #%d".formatted(i))));
    }

    private final List<Product> products =
            Collections.synchronizedList(new LinkedList<>());

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(this.products);
    }

    @Override
    public Product save(Product product) {
        product.setId(this.products.stream()
                                   .max(Comparator.comparingInt(Product::getId))
                                   .map(Product::getId)
                                   .orElse(0) + 1);
        this.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(int productId) {
        return this.products.stream()
                            .filter(product -> Objects.equals(productId, product.getId()))
                            .findFirst();
    }
}
