package com.stack.model.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    @ParameterizedTest(name = "{0} has same name as {1}")
    @ArgumentsSource(EmployeeArgumentsProvider.class)
    void testIsSameName(Employee alice, Employee bob, boolean expected) {
        assertEquals(expected, alice.isSameName(bob));
    }

    @ParameterizedTest(name = "{0} equals {1}")
    @ArgumentsSource(EmployeeArgumentsProvider.class)
    void testEquals(Employee a, Employee b, boolean expected) {
        assertEquals(a.equals(b), expected);
    }

    @ParameterizedTest(name = "{0} hashCode equals {1} hashCode")
    @ArgumentsSource(EmployeeArgumentsProvider.class)
    void testHashCode(Employee a, Employee b, boolean expected) {
        assertEquals(a.hashCode()==b.hashCode(), expected);
    }
}
