package com.stack.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumbersTest {

    @Test(dataProvider = "evenNumbers")
    public void testIsEvenEvenNumber(String number, String expected) {
        assertEquals(Numbers.isEven(number), expected);
    }

    @Test(dataProvider = "oddNumbers")
    public void testIsEvenOddNumber(String number, String expected) {
        assertEquals(Numbers.isEven(number), expected);
    }

    @Test(dataProvider = "testCases")
    public void testIsEvenInvalidInput(String number, String expected) {
        assertEquals(Numbers.isEven(number), expected);
    }

    @DataProvider(name = "evenNumbers")
    public Object[][] evenNumbers() {
        return new Object[][] {
                {"10", "Even"},
                {"100", "Even"},
                {"-2", "Even"}
        };
    }

    @DataProvider(name = "oddNumbers")
    public Object[][] oddNumbers() {
        return new Object[][] {
                {"7", "Odd"},
                {"15", "Odd"},
                {"-11", "Odd"}
        };
    }

    @DataProvider(name = "testCases")
    public Object[][] testCases() {
        return new Object[][] {
                {"-", "Invalid Data"},
                {"", "Invalid Data"},
                {null, "Invalid Data"},
                {"--10", "Invalid Data"},
                {"++7", "Invalid Data"},
                {"abc", "Invalid Data"}
        };
    }
}
