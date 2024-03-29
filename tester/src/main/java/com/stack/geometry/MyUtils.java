package com.stack.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {

    public List<Shape> maxAreas(List<Shape> shapes) {

        Map<String, List<Shape>> shapeMap = new HashMap<>();
        for (Shape shape : shapes) {
            String shapeType = shape.getClass().getSimpleName();
            shapeMap.computeIfAbsent(shapeType, k -> new ArrayList<>()).add(shape);
        }

        List<Shape> maxAreaShapes = new ArrayList<>();
        for (List<Shape> shapeList : shapeMap.values()) {
            double maxArea = Collections.max(shapeList, Comparator.comparing(Shape::getArea)).getArea();
            for (Shape shape : shapeList) {
                if (Double.compare(shape.getArea(), maxArea) == 0) {
                    maxAreaShapes.add(shape);
                }
            }
        }
        return maxAreaShapes;
    }

    public double sumPerimeter(List<? extends Figure> figures) {
        double sum = 0;
        for (Figure figure : figures) {
            sum += figure.getPerimeter();
        }
        return sum;
    }
}
