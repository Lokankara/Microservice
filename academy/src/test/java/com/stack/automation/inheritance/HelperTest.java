package com.stack.automation.inheritance;

import com.stack.automation.geometry.Circle;
import com.stack.automation.geometry.Figure;
import com.stack.automation.geometry.Helper;
import com.stack.automation.geometry.Rectangle;
import com.stack.automation.geometry.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HelperTest {

    @ParameterizedTest
    @ArgumentsSource(MaxAreasArgumentsProvider.class)
    void testMaxAreas(List<Shape> shapes, int expectedSize) {
        List<Shape> maxAreas = new Helper().maxAreas(shapes);
        assertEquals(expectedSize, maxAreas.size());
    }

    @ParameterizedTest
    @ArgumentsSource(PerimeterProvider.class)
    void testSumPerimeter(List<? extends Figure> figures, double expectedSum) {
        double sum = new Helper().sumPerimeter(figures);
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

        List<Shape> maxAreaShapes = new Helper().maxAreas(shapes);
        assertEquals(4, maxAreaShapes.size());
        assertTrue(maxAreaShapes.get(0) instanceof Circle || maxAreaShapes.get(0) instanceof Rectangle);
        assertTrue(maxAreaShapes.get(1) instanceof Circle || maxAreaShapes.get(1) instanceof Rectangle);
        Assertions.assertEquals(maxAreaShapes.get(0).getClass(), maxAreaShapes.get(1).getClass());
    }
}
