package com.stack.number.providers;

import org.testng.annotations.DataProvider;

import java.math.BigDecimal;

import static java.lang.Long.MAX_VALUE;

public class GeometryProvider {
    @DataProvider(name = "perimeterData")
    public Object[][] createPerimeterData() {
        return new Object[][] {
                { new double[]{5, 5, 5, 5}, 20 },
                { new double[]{1, 2, 3, 4}, 10 },
                { new double[]{MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE},
                        new BigDecimal(MAX_VALUE).multiply(new BigDecimal("4")).doubleValue() },
                { new double[]{5.0, 5.0, 5.0, 5.0}, 20.0 },
                { new double[]{1.0, 2.0, 3.0, 4.0}, 10.0 },
                { new double[]{2.0, 2.0, 2.0, 2.0}, 8.0 },
                { new double[]{3.0, 3.0, 3.0, 3.0}, 12.0 },
                { new double[]{4.0, 4.0, 4.0, 4.0}, 16.0 },
                { new double[]{5.0, 5.0, 5.0, 5.0}, 20.0 },
                { new double[]{6.0, 6.0, 6.0, 6.0}, 24.0 },
                { new double[]{7.0, 7.0, 7.0, 7.0}, 28.0 },
                { new double[]{8.0, 8.0, 8.0, 8.0}, 32.0 },
                { new double[]{9.0, 9.0, 9.0, 9.0}, 36.0 }
        };
    }

    @DataProvider(name = "areaData")
    public Object[][] createAreaData() {
        return new Object[][] {
                { 2, 3, 4, 52 },
                { 1, 1, 1, 6 },
                { 1.0, 1.0, 1.0, 6.0 },
                { 2.0, 2.0, 2.0, 24.0 },
                { 3.0, 3.0, 3.0, 54.0 },
                { 2.0, 3.0, 4.0, 52.0 },
                { 4.0, 4.0, 4.0, 96.0 },
                { 5.0, 5.0, 5.0, 150.0 },
                { 6.0, 6.0, 6.0, 216.0 },
                { 7.0, 7.0, 7.0, 294.0 },
                { 8.0, 8.0, 8.0, 384.0 },
                { 9.0, 9.0, 9.0, 486.0 }
        };
    }

    @DataProvider(name = "negativePerimeterData")
    public Object[][] createNegativePerimeterData() {
        return new Object[][] {
                { new double[]{0, 5, 5, 5}, 0 },
                { new double[]{1, -2, 3, 4}, 0 },
                { new double[]{-1, -2, -3, -4}, 0 },
                { new double[]{0.0, 0.0, 0., 0.0}, 0 },
                { new double[]{1.0, -2.0, 3.0, 4.0}, 0.0 },
                { new double[]{-1.0, -2.0, -3.0, -4.0}, 0.0 }
        };
    }

    @DataProvider(name = "negativeAreaData")
    public Object[][] createNegativeAreaData() {
        return new Object[][] {
                { 0, 3, 4, 0 },
                { 1, -1, 1, 0 },
                { -1, -1, -1, 0 },
                {-1.0, 3.0, 4.0, 0},
                {1.0, -1.0, 1.0, 0},
                { 0.0, 0.0, 0.0, 0.0 },
                { -1.0, 3.0, 4.0, 0.0 },
                { 1.0, -1.0, 1.0, 0.0 },
                { 1.0, 1.0, -1.0, 0.0 },
                { -1.0, -1.0, -1.0, 0.0 }
        };
    }
}
