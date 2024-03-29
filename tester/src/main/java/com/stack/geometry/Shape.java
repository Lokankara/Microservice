package com.stack.geometry;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class Shape {

    private final String name;

    protected Shape(String name) {
        this.name = name;
    }

    public abstract double getArea();
}
