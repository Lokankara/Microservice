package com.stack.automation.geometry;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class Rectangle extends Shape implements Figure {
    private final double height;
    private final double width;

    public Rectangle() {
        super("Rectangle");
        this.height = 0;
        this.width = 0;
    }

    public Rectangle(
            String name,
            double height,
            double width) {
        super(name);
        this.height = height;
        this.width = width;
    }

    public Rectangle(double height, double width) {
        super("Rectangle");
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public String toString() {
        return String.format(
                "Rectangle [height=%.2f, width=%.2f]",
                height, width);
    }
}
