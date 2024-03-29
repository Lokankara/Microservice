package com.stack.geometry;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Square extends Shape implements Figure{
    private final double side;

    public Square(
            double side) {
        super("Square");
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}
