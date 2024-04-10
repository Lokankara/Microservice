package com.stack.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Employee {
    private String id;
    private double salary;
    private String firstname;
    private boolean paid;

    public Employee(
            String id,
            double salary) {
        this.id = id;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0
               && Objects.equals(id, employee.id)
               && Objects.equals(firstname, employee.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, firstname);
    }
}
