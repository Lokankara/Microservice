package com.stack.model.company;

import com.stack.model.time.Month;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Manager extends Employee {

    private int subordinates;
    private Employee[] employee;

    public Manager(
            String name,
            int age,
            Gender gender,
            double salary,
            int subordinates) {
        super(name, age, gender, salary);
        this.subordinates = subordinates;
        this.employee = new Employee[subordinates];
    }

    @Override
    public double getSalary(Month[] monthArray) {
        double totalSalary = super.getSalary(monthArray);
        double bonusPercentage = subordinates * 0.01;
        totalSalary += totalSalary * bonusPercentage;
        return totalSalary;
    }
}
