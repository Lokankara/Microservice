package com.stack.time;

import org.testng.annotations.DataProvider;

import static com.stack.time.MonthType.*;

public class MonthProvider {

    @DataProvider(name = "daysProvider")
    public Object[][] daysProvider() {
        return new Object[][] {
                {31, new String[] {
                        JANUARY.getName(), MARCH.getName(),
                        MAY.getName(), JULY.getName(),
                        AUGUST.getName(), OCTOBER.getName(),
                        DECEMBER.getName()}},
                {30, new String[] {
                        APRIL.getName(), JUNE.getName(),
                        SEPTEMBER.getName(), NOVEMBER.getName()}},
                {29, new String[] {FEBRUARY.getName()}},
                {28, new String[] {FEBRUARY.getName()}}
        };
    }

    @DataProvider(name = "invalidDaysProvider")
    public Object[][] invalidDaysProvider() {
        return new Object[][] {
                {-1},
                {0},
                {32},
                {100}
        };
    }
}
