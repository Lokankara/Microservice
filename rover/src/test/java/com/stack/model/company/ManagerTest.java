package com.stack.model.company;

import com.stack.model.provider.ManagerArgumentsProvider;
import com.stack.model.time.Month;
import com.stack.model.time.MonthUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {

    @ParameterizedTest
    @ArgumentsSource(ManagerArgumentsProvider.class)
    void testGetSalary(String name, int age, Gender gender, int perDay, int subordinates, int year, double expected) {
        Manager manager = new Manager(age, name, gender, 1000, perDay, subordinates);
        Month[] months = MonthUtils.map(MonthUtils.MONTHS, year);
        double actualSalary = manager.getSalary(months);
        assertEquals(expected, actualSalary, "Salary calculation should be correct");
    }

    @Test
    void testGetSalary() {
        Manager manager = new Manager(42, "Jack", Gender.MALE,  1000, 10, 1);
        int year = 2001;
        double expected = 2510;
        MonthUtils[] utils = {MonthUtils.JANUARY, MonthUtils.FEBRUARY};
        Month[] months = MonthUtils.map(utils, year);
        double actualSalary = manager.getSalary(months);
        assertEquals(expected, actualSalary, "Salary calculation should be correct");
    }
}
