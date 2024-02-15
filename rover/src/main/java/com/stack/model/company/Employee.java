package com.stack.model.company;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Employee
        extends Entity {

    public Employee(
            String name,
            int age,
            Gender gender,
            double salary) {
        super(name, age, gender);
        this.salary = salary;
    }

    private double salary;

    public boolean isSameName(Employee employee) {
        return this.name.equals(employee.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }

    @Override
    public String toString() {
        return "Employee{salary=%s, name='%s', age=%d, gender=%s}"
                .formatted(salary, name, age, gender);
    }
}
