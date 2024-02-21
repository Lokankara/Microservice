package com.stack.model.company;

import com.stack.model.provider.SalaryArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalaryTest {

    @ParameterizedTest(name = "{0}, {1}")
    @ArgumentsSource(SalaryArgumentsProvider.class)
    void testGetSum(Employee[] employeeArray, double expectedSum) {
        Salary salary = new Salary();
        assertEquals(expectedSum, salary.getSum(employeeArray));
    }
}
