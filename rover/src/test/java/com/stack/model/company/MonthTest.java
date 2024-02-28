package com.stack.model.company;

import com.stack.model.provider.MonthArgumentsProvider;
import com.stack.model.provider.QuarterArgumentsProvider;
import com.stack.model.time.Date;
import com.stack.model.time.Day;
import com.stack.model.time.Month;
import com.stack.model.time.MonthUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static com.stack.model.time.MonthUtils.APRIL;
import static com.stack.model.time.MonthUtils.AUGUST;
import static com.stack.model.time.MonthUtils.DECEMBER;
import static com.stack.model.time.MonthUtils.FEBRUARY;
import static com.stack.model.time.MonthUtils.JANUARY;
import static com.stack.model.time.MonthUtils.JULY;
import static com.stack.model.time.MonthUtils.JUNE;
import static com.stack.model.time.MonthUtils.MARCH;
import static com.stack.model.time.MonthUtils.MAY;
import static com.stack.model.time.MonthUtils.NOVEMBER;
import static com.stack.model.time.MonthUtils.OCTOBER;
import static com.stack.model.time.MonthUtils.SEPTEMBER;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MonthTest {

    @ParameterizedTest
    @ArgumentsSource(MonthArgumentsProvider.class)
    void testGetNumberOfWorkingDays(
            MonthUtils utils, int year,
            int workingDays, int days) {
        int actualWorkingDays = utils.getWorkingDays(year);
        Month month = new Month(utils.getName(), days, actualWorkingDays);
        assertEquals(month.days(), utils.getDays(year));
        assertEquals(month.workingDays(), workingDays);
        assertEquals(days, utils.getDays(year));
        assertEquals(workingDays, actualWorkingDays,
                     "For %s %d, expected: %d, actual: %d".formatted(
                             utils.getName(), year, workingDays, actualWorkingDays));
    }

    @ParameterizedTest
    @ArgumentsSource(MonthArgumentsProvider.class)
    void testGetNumberOfWorkingDaysWithSalary(MonthUtils utils, int year) {
        int salary = 50;
        int actualWorkingDays = utils.getWorkingDays(year);
        int days = utils.getDays(year);
        Month month = new Month(utils.getName(), days, actualWorkingDays);
        BaseEmployee employee = new Worker(40, "Bob", Gender.MALE, salary);
        Month[] months = { month };
        assertEquals(month.days(), days);
        assertEquals(employee.getSalary(months), salary);
    }

    @Test
    void testPlusDays(){
        int days = 4;
        Date date = new Date(25, MonthUtils.FEBRUARY, 2025);
        Date plussed = date.plusDays(days);
        assertEquals(plussed.day(), date.day() + days);
    }

    @Test
    void testGetDaysOfMonth() {
        Day[] days = MonthUtils.JANUARY.getDaysOfMonth(2021);
        assertEquals(31, days.length);
        days = MonthUtils.FEBRUARY.getDaysOfMonth(2021);
        assertEquals(28, days.length);
        days = MonthUtils.FEBRUARY.getDaysOfMonth(2020);
        assertEquals(29, days.length);
    }

    @ParameterizedTest
    @ArgumentsSource(QuarterArgumentsProvider.class)
    void testGetQuarter(MonthUtils[] expectedMonths, int quarter) {
        assertArrayEquals(expectedMonths, MonthUtils.getQuarter(quarter));
    }

    @Test
    void testGetHalf() {
        MonthUtils[] expected = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE};
        assertArrayEquals(expected, MonthUtils.getHalf(1));
        expected = new MonthUtils[]{JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
        assertArrayEquals(expected, MonthUtils.getHalf(2));
    }

    @Test
    void testGetYear() {
        MonthUtils[] expected = MonthUtils.MONTHS;
        assertArrayEquals(expected, MonthUtils.getYear());
    }
}
