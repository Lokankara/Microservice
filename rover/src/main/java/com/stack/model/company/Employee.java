package com.stack.model.company;

import com.stack.model.time.Month;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Employee
        extends Entity {

    private double salaryPerDay;

    double getSalary(Month[] monthArray){
        double amount = 0;
        for (Month month : monthArray) {
            amount += month.workingDays() * salaryPerDay;
        }
        return amount;
    }

    public Employee(
            String name,
            int age,
            Gender gender,
            double salary) {
        super(name, age, gender);
        this.salaryPerDay = salary;
    }

    public boolean isSameName(Employee employee) {
        return this.name.equals(employee.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(salaryPerDay, employee.salaryPerDay) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salaryPerDay);
    }

    @Override
    public String toString() {
        return "Employee{salary=%s, name='%s', age=%d, gender=%s}"
                .formatted(salaryPerDay, name, age, gender);
    }
}
