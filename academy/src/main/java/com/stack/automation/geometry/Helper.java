package com.stack.automation.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Helper {

    public List<Shape> maxAreas(List<Shape> shapes) {

        Map<String, List<Shape>> shapeMap = new HashMap<>();
        for (Shape shape : shapes) {
            shapeMap.computeIfAbsent(
                    shape.getClass().getSimpleName(),
                    k -> new ArrayList<>()).add(shape);
        }

        List<Shape> maxAreaShapes = new ArrayList<>();
        for (List<Shape> shapeList : shapeMap.values()) {
            double maxArea = Collections.max(shapeList, Comparator.comparing(Shape::getArea)).getArea();
            shapeList.stream()
                     .filter(shape -> Double.compare(shape.getArea(), maxArea) == 0)
                     .forEach(maxAreaShapes::add);
        }
        return maxAreaShapes;
    }

    public double sumPerimeter(List<? extends Figure> figures) {
        return figures.stream()
                      .mapToDouble(Figure::getPerimeter)
                      .sum();
    }
}
