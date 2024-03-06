package com.stack.time;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.testng.Assert.assertEquals;

public class MonthTypeTest {

    @Test(dataProvider = "daysProvider", dataProviderClass = MonthProvider.class)
    public void testGetMonthsByDays(int days, String[] expected) {
        String[] result = MonthDaysCalculator.getMonthsByDays(days);
        assertArrayEquals(result, expected);
    }

    @Test(dataProvider = "invalidDaysProvider", dataProviderClass = MonthProvider.class)
    public void testGetMonthsByInvalidDays(int days) {
        String[] result = MonthDaysCalculator.getMonthsByDays(days);
        assertEquals(result.length, 0);
    }
}
