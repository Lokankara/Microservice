package com.stack.number;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.stack.number.Operations.multiplyAllAndMultiplyByE;
import static com.stack.number.Operations.sumAndMultiplyByPi;
import static org.testng.AssertJUnit.assertEquals;

public class OperationsTest {

    @DataProvider(name = "testDataForSum")
    public Object[][] createDataForSum() {
        return new Object[][] {
                { new Integer[]{1, 2, 3}, 6 * Math.PI }
        };
    }

    @DataProvider(name = "testDataForMultiply")
    public Object[][] createDataForMultiply() {
        return new Object[][] {{ new Short[]{1, 2, 3}, 6 * Math.E }
        };
    }

    @Test(dataProvider = "testDataForSum")
    public void testSumAndMultiplyByPi(Integer[] numbers, double expected) {
        assertEquals(sumAndMultiplyByPi(numbers), expected);
    }

    @Test(dataProvider = "testDataForMultiply")
    public void testMultiplyAllAndMultiplyByE(Short[] numbers, double expected) {
        assertEquals(multiplyAllAndMultiplyByE(numbers), expected);
    }
}
