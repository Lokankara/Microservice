package com.stack.model.company;

public final class Employee
        extends BaseEmployee {

    public Employee(
            int age,
            String name,
            Gender gender) {
        super(age, name, gender);
    }

    @Override
    public double getSalary() {
        return getSubordinates() < 1
               ? getBaseSalary()
               : getBaseSalary() + getBonus(getPercent());
    }

    public Employee(
            int age,
            String name,
            Gender gender,
            double baseSalary) {
        super(age, name, gender, baseSalary);
    }

    public Employee(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay) {
        super(age, name, gender, baseSalary, salaryPerDay);
    }

    public Employee(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay,
            int subordinates) {
        super(age, name, gender, baseSalary, salaryPerDay, subordinates);
    }

    public boolean isSameName(Employee employee) {
        return this.getName().equalsIgnoreCase(employee.getName());
    }
}
