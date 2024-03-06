package com.stack.number;

import com.stack.number.providers.GeometryProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GeometryTest {

    @Test(dataProvider = "negativePerimeterData",
            dataProviderClass = GeometryProvider.class)
    public void testCalculatePerimeterNegative(
            double[] p, double expected) {
        double actual = Geometry.calculatePerimeter(p[0], p[1], p[2], p[3]);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "negativeAreaData",
            dataProviderClass = GeometryProvider.class)
    public void testCalculateAreaNegative(
            double length, double width, double height, double expected) {
        double actual = Geometry.calculateArea(length, width, height);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "perimeterData",
            dataProviderClass = GeometryProvider.class)
    public void testCalculatePerimeter(
            double[] p, double expected) {
        assertEquals(Geometry.calculatePerimeter(p[0], p[1], p[2], p[3]), expected);
    }

    @Test(dataProvider = "areaData",
            dataProviderClass = GeometryProvider.class)
    public void testCalculateArea(
            double length, double width, double height, double expected) {
        assertEquals(Geometry.calculateArea(length, width, height), expected);
    }
}
