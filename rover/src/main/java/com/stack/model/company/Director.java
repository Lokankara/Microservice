package com.stack.model.company;

public class Director
        extends Manager {

    public Director(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay,
            int subordinates
            ) {
        super(age, name, gender, baseSalary, salaryPerDay, subordinates);
    }

    @Override
    public double getSalary() {
        return super.getSubordinates() < 1
               ? getBaseSalary()
               : getBaseSalary() + getBonus(0.09);
    }
}
