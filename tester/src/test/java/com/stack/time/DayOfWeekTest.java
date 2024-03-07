package com.stack.time;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.stack.time.DayOfWeek.getDayOfWeek;
import static org.testng.Assert.assertEquals;
public class DayOfWeekTest {

    @DataProvider(name = "validData")
    public Object[][] validData() {
        return new Object[][] {
                {1, "Monday"},
                {2, "Tuesday"},
                {3, "Wednesday"},
                {4, "Thursday"},
                {5, "Friday"},
                {6, "Saturday"},
                {7, "Sunday"}
        };
    }

    @DataProvider(name = "invalidData")
    public Object[][] invalidData() {
        return new Object[][] {
                {null},
                {0},
                {8},
                {-1},
                {100}
        };
    }

    @Test(dataProvider = "validData")
    public void testValidData(Integer dayNumber, String expectedDay) {
        assertEquals(getDayOfWeek(dayNumber), expectedDay);
    }

    @Test(dataProvider = "invalidData")
    public void testInvalidData(Integer dayNumber) {
        assertEquals(getDayOfWeek(dayNumber), "Incorrect number of week");
    }
}
