package com.stack.model.company;

import lombok.Getter;

import java.util.Arrays;

@Getter
public final class Manager
        extends BaseEmployee {

    private final Employee[] employees;
    private static final double PERCENT = 0.03;

    public Manager(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay
            ) {
        super(age, name, gender, baseSalary, salaryPerDay);
        this.employees = new Employee[0];
    }

    public Manager(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay,
            int subordinates) {
        super(age, name, gender, baseSalary, salaryPerDay, subordinates);
        this.employees = subordinates > 0
                        ? new Employee[subordinates]
                        : new Employee[0];
    }

    @Override
    public double getSalary() {
        return getSubordinates() < 1
               ? getBaseSalary()
               : getBaseSalary() + getBonus(getPercent());
    }

    @Override
    public double getPercent() {
        return PERCENT;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Arrays.equals(employees, manager.employees);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Arrays.hashCode(employees);
    }
}
