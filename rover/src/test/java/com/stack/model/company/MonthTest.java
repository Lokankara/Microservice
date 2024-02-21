package com.stack.model.company;

import com.stack.model.provider.MonthArgumentsProvider;
import com.stack.model.time.Date;
import com.stack.model.time.Month;
import com.stack.model.time.MonthUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

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
        int salary = 25;
        int actualWorkingDays = utils.getWorkingDays(year);
        int days = utils.getDays(year);
        Month month = new Month(utils.getName(), days, actualWorkingDays);
        Employee employee = new Employee("Bob", 40, Gender.MAN, salary);
        Month[] months = { month };
        assertEquals(month.days(), days);
        assertEquals(employee.getSalary(months), salary * actualWorkingDays);
    }

    @Test
    void testPlusDays(){
        int days = 4;
        Date date = new Date(25, MonthUtils.FEBRUARY, 2025);
        Date plussed = date.plusDays(days);
        assertEquals(plussed.day(), date.day() + days);
    }
}
