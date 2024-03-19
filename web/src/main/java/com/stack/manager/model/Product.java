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
    private final String title;
    private final String details;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Product) obj;
        return this.id == that.id
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, details);
    }
}
