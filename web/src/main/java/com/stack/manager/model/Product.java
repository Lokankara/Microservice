package com.stack.manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@ToString
@AllArgsConstructor
public final class Product {

    private int id;
    private String url;
    private Double price;
    private String title;
    private String details;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id
                && Double.compare(price, product.price) == 0
                && Objects.equals(url, product.url)
                && Objects.equals(title, product.title)
                && Objects.equals(details, product.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, price, title, details);
    }
}
