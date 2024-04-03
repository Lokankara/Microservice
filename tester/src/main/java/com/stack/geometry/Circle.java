package com.stack.geometry;

import lombok.Getter;

@Getter
public class Circle
        extends Shape {
    private double radius;

    public Circle(
            String name,
            double radius) {
        super(name);
        this.radius = radius;
    }

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    public Circle() {
        super("Circle");
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle [radius=%.2f]", radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }
}
