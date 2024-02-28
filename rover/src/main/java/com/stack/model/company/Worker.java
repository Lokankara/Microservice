package com.stack.model.company;

public class Worker extends BaseEmployee {

    public Worker(
            int age,
            String name,
            Gender gender,
            double salary) {
        super(age, name, gender, salary);
    }

    public Worker() {
        super(0, null, Gender.UNKNOWN);
    }

    @Override
    double getSalary() {
        return getBaseSalary();
    }

    @Override
    public final double getBaseSalary() {
        return super.getBaseSalary();
    }
}
