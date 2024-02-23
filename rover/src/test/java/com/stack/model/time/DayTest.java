package com.stack.model.time;

import com.stack.model.provider.DayArgumentsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DayTest {

    @Test
    void testDayOfWeek() {
        Day day1 = new Day(22, 2, 2024);
        assertEquals(Week.THURSDAY, day1.getDayOfWeek());
        Day day2 = new Day(15, 2, 2024);
        assertEquals(Week.THURSDAY, day2.getDayOfWeek());
        Day day3 = new Day(29, 2, 2024);
        assertEquals(Week.THURSDAY, day3.getDayOfWeek());
        Day day4 = new Day(1, 1, 2025);
        assertEquals(Week.WEDNESDAY, day4.getDayOfWeek());
        Day day5 = new Day(22, 2, 1900);
        assertEquals(Week.THURSDAY, day5.getDayOfWeek());
    }

    @Test
    void testIsWorkingDay() {
        Day day1 = new Day(22, 2, 2024);
        assertTrue(day1.isWorkingDay());
        Day day2 = new Day(15, 2, 2024);
        assertTrue(day2.isWorkingDay());
        Day day3 = new Day(29, 2, 2024);
        assertTrue(day3.isWorkingDay());
        Day day4 = new Day(1, 1, 2025);
        assertTrue(day4.isWorkingDay());
        Day day5 = new Day(22, 2, 1900);
        assertTrue(day5.isWorkingDay());
    }

    @ParameterizedTest
    @ArgumentsSource(DayArgumentsProvider.class)
    void testGetDayOfWeekSakamotoAlgorithm(
            int dayNumber,
            MonthUtils month,
            int year,
            Week expectedDay,
            boolean isWorkingDay) {
        int ordinal = month.ordinal() + 1;
        Day day = new Day(dayNumber, ordinal, year);
        assertEquals(expectedDay, day.getDayOfWeek(ordinal, year));
        assertEquals(isWorkingDay, day.isWorkingDay());
    }
}
