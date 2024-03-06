package com.stack.number;

public class Geometry {

    private Geometry() {
    }

    public static double calculatePerimeter(
            double a, double b, double c, double d) {
        return isValid(a, b, c, d) ? a + b + c + d : 0;
    }

    private static boolean isValid(
            double a, double b, double c, double d) {
        return !(a <= 0 || b <= 0 || c <= 0 || d <= 0);
    }

    private static boolean isValid(
            double length, double width, double height) {
        return !(length <= 0 || width <= 0 || height <= 0);
    }

    public static double calculateArea(
            double length, double width, double height) {
        return isValid(length, width, height)
               ? 2 * (length * width + width * height + length * height)
               : 0;
    }
}
