package com.stack.model.company;

import com.stack.model.provider.EmployeeUtilsArgumentsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeUtilsTest {

    private static final Manager[] managers = {
            new Manager(35, "Jack", Gender.MALE, 10000, 20, 10),
            new Manager(40, "Alice", Gender.FEMALE, 10000, 20,  0),
            new Manager(40, "Kate", Gender.FEMALE, 10000, 20,  1),
            new Manager(31, "John", Gender.MALE, 10000, 20,  -1),
    };

    @Test
    void testFindEmployeeByName() {
        assertEquals("Jack", EmployeeUtils.findEmployeeByName(managers, "Jack").getName());
    }

    @Test
    void testFindEmployeeBySubstring() {
        assertEquals("Kate", EmployeeUtils.findEmployeeBySubstring(managers, "Ka").getName());
    }

    @Test
    void testCalculateTotalSalaryBudget() {
        assertEquals(43300, EmployeeUtils.calculateTotalSalary(managers));
    }

    @Test
    void testFindMinimumSalary() {
        assertEquals(10000, EmployeeUtils.findMinimumSalary(managers));
    }

    @Test
    void testFindMaximumSalary() {
        assertEquals(13000, EmployeeUtils.findMaximumSalary(managers));
    }

    @Test
    void testFindMinimumSubordinates() {
        assertEquals(0, EmployeeUtils.findMinSubordinates(managers));
    }

    @Test
    void testFindMaximumSubordinates() {
        assertEquals(10, EmployeeUtils.findMaxSubordinates(managers));
    }

    @Test
    void testFindMaxAllowance() {
        assertEquals(3000, EmployeeUtils.findMaxAllowance(managers));
    }

    @Test
    void testFindMinAllowance() {
        assertEquals(0, EmployeeUtils.findMinAllowance(managers));
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testFindEmployeeByName(Employee[] managers) {
        assertEquals("Jack", EmployeeUtils.findEmployeeByName(managers, "Jack").getName());
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testFindEmployeeBySubstring(Employee[] managers) {
        String[] arr = {"Jack", "Jill", "Joan", "John"};
        assertEquals("Jack", EmployeeUtils.findEmployeeBySubstring(managers, "J").getName());
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testCalculateTotalSalaryBudget(Employee[] managers, int i) {
        int[] salaries = {43300, 50800};
        assertEquals(salaries[i], EmployeeUtils.calculateTotalSalary(managers));
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testFindMinimumSalary(Employee[] managers) {
        assertEquals(10000, EmployeeUtils.findMinimumSalary(managers));
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testFindMaximumSalary(Employee[] managers, int i) {
        int[] salaries = {13000, 19000};
        assertEquals(salaries[i], EmployeeUtils.findMaximumSalary(managers));
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testFindMinimumSubordinates(Employee[] managers) {
        assertEquals(0, EmployeeUtils.findMinSubordinates(managers));
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testFindMaximumSubordinates(Employee[] managers) {
        assertEquals(10, EmployeeUtils.findMaxSubordinates(managers));
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testFindMaxAllowance(Employee[] managers, int i, double salary, int allowance) {
        assertEquals(allowance, EmployeeUtils.findMaxAllowance(managers));
    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeUtilsArgumentsProvider.class)
    void testFindMinAllowance(Employee[] managers) {
        assertEquals(0, EmployeeUtils.findMinAllowance(managers));
    }
}
