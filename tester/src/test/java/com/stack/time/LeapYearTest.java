package com.stack.time;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.stack.time.MonthType.isLeapYear;

public class LeapYearTest {

    @DataProvider(name = "validData")
    public Object[][] validData() {
        return new Object[][] {
                {4, "Leap year"},
                {2000, "Leap year"},
                {1004, "Leap year"},
                {1904, "Leap year"},
                {2020, "Leap year"}
        };
    }

    @DataProvider(name = "invalidData")
    public Object[][] invalidData() {
        return new Object[][] {
                {1, "No leap year"},
                {3000, "No leap year"},
                {1000, "No leap year"},
                {1900, "No leap year"},
                {2001, "No leap year"},
                {2022, "No leap year"}
        };
    }

    @DataProvider(name = "emptyData")
    public Object[][] emptyData() {
        return new Object[][] {
                {"", "Error"},
                {"qwerty", "Error"},
                {"--12", "Error"},
                {"++12", "Error"},
                {"12!", "Error"},
                {null, "Error"},
                {0, "Error"},
                {-10, "Error"},
                {3001, "Error"}
        };
    }

    @Test(dataProvider = "validData")
    public void testValidData(int year, String expectedResult) {
        testLeapYear(year, expectedResult);
    }

    @Test(dataProvider = "invalidData")
    public void testInvalidData(int year, String expectedResult) {
        testLeapYear(year, expectedResult);
    }

    @Test(dataProvider = "emptyData")
    public void testEmptyData(Object year, String expectedResult) {
        testLeapYear(year, expectedResult);
    }

    private void testLeapYear(Object year, String expectedResult) {
        Assert.assertEquals(isLeapYear(year), expectedResult);
    }
}
