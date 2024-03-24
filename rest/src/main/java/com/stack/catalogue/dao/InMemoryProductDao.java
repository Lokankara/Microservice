package com.stack.catalogue.dao;

import com.stack.catalogue.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryProductDao
        implements ProductDao {

    public InMemoryProductDao() {
        Map<Integer, Map<String, String>> data = Map.of(
                1, Map.of("title", "Asics", "price", "69.89", "image", "https://i.imgur.com/KuyqTcl.png"),
                2, Map.of("title", "Adidas", "price", "34.29", "image", "https://i.imgur.com/V3azz7X.png"),
                3, Map.of("title", "New Balance", "price", "44.59", "image", "https://i.imgur.com/2YRJN6g.png")
        );
        data.forEach((id, productData) -> {
            String title = productData.get("title");
            Double price = Double.parseDouble(productData.get("price")) ;
            String image = productData.get("image");
            Product product = new Product(id, image, price, title, "Description #%d".formatted(id));
            products.add(product);
        });
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

    @Override
    public void deleteById(int id) {
        this.products.removeIf(product -> Objects.equals(id, product.getId()));
    }
}
