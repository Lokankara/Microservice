package com.stack.number;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class NumbersTest {

    @Test(dataProvider = "validNumberArrayProvider",
            dataProviderClass = DataNumbersProvider.class)
    public void testFindMedianValidNumberArrayProvider(int[] input, double expected) {
        double actual = Numbers.findMedian(input);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "validNumberArrayProvider",
            dataProviderClass = DataNumbersProvider.class)
    public void testFindMedianValidNumberArrayProviderQuickSelect(int[] input, double expected) {
        double actual = QuickSelect.findMedian(input);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "invalidNumberArrayProvider",
            expectedExceptions = IllegalArgumentException.class,
            dataProviderClass = DataNumbersProvider.class)
    public void testCalculateMedianWithInvalidInput(int[] numbers) {
        Numbers.findMedian(numbers);
    }

    @Test(dataProvider = "singleElementArrayProvider",
            dataProviderClass = DataNumbersProvider.class)
    public void testFindMedianValidNumberArrayProviderWithSingleElementArrayProvider(int[] input, double expected) {
        double actual = Numbers.findMedian(input);
        assertEquals(actual, expected);
    }
}
