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
    void testGetSalary(String name, int age, Gender gender, int salaryPerDay, int numberOfSubordinates, int year, double expectedSalary) {
        Manager manager = new Manager(name, age, gender, salaryPerDay, numberOfSubordinates);
        Month[] months = map(MonthUtils.ENUMS, year);
        double actualSalary = manager.getSalary(months);
        assertEquals(expectedSalary, actualSalary, "Salary calculation should be correct");
    }

    @Test
    void testGetSalary() {
        Manager manager = new Manager("Jack", 35, Gender.MAN, 200, 5);
        int year = 2001;
        double expected = 13650.0;
        MonthUtils[] utils = {MonthUtils.JANUARY, MonthUtils.FEBRUARY, MonthUtils.MARCH};
        Month[] months = map(utils, year);
        double actualSalary = manager.getSalary(months);
        assertEquals(expected, actualSalary, "Salary calculation should be correct");
    }

    private Month[] map(MonthUtils[] monthUtils, int year) {
        int size = monthUtils.length;
        Month[] months = new Month[size];
        for (int i = 0; i < size; i++) {
            months[i] = new Month(monthUtils[i].getName(),
                                  monthUtils[i].getDays(year),
                                  monthUtils[i].getWorkingDays(year));
        }
        return months;
    }
}
