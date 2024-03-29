package com.stack.polimorphism;

import com.stack.geometry.Circle;
import com.stack.geometry.Figure;
import com.stack.geometry.MyUtils;
import com.stack.geometry.Rectangle;
import com.stack.geometry.Shape;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyUtilsTest {

    @ParameterizedTest
    @ArgumentsSource(MaxAreasArgumentsProvider.class)
    void testMaxAreas(List<Shape> shapes, int expectedSize) {
        List<Shape> maxAreas = new MyUtils().maxAreas(shapes);
        assertEquals(expectedSize, maxAreas.size());
    }

    @ParameterizedTest
    @ArgumentsSource(PerimeterProvider.class)
    void testSumPerimeter(List<? extends Figure> figures, double expectedSum) {
        double sum = new MyUtils().sumPerimeter(figures);
        assertEquals(expectedSum, sum);
    }

    @Test
    void testDuplicateConditions() {
        List<Shape> shapes = Arrays.asList(
                new Circle(1.0),
                new Rectangle(1.0, Math.PI),
                new Circle(1.0),
                new Rectangle(1.0, Math.PI)
        );

        List<Shape> maxAreaShapes = new MyUtils().maxAreas(shapes);
        assertEquals(4, maxAreaShapes.size());
        assertTrue(maxAreaShapes.get(0) instanceof Circle || maxAreaShapes.get(0) instanceof Rectangle);
        assertTrue(maxAreaShapes.get(1) instanceof Circle || maxAreaShapes.get(1) instanceof Rectangle);
        assertEquals(maxAreaShapes.get(0).getClass(), maxAreaShapes.get(1).getClass());
    }
}
