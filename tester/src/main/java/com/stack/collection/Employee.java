package com.stack.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Employee implements Comparator<Employee> {

    private final String name;
    private final int experience;
    private final BigDecimal basePayment;

    @Override
    public int compare(Employee e1, Employee e2) {
        return Comparator.comparing(Employee::getName)
                         .thenComparing(Employee::getExperience)
                         .thenComparing(Employee::getBasePayment)
                         .compare(e1, e2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return experience == employee.experience
               && Objects.equals(name, employee.name)
               && Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, basePayment);
    }
}
