package com.stack.model.company;

import com.stack.model.time.Month;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Manager
        extends Employee {

    private int subordinates;
    private Employee[] employee;

    public Manager(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay
            ) {
        super(age, name, gender, baseSalary, salaryPerDay);
        this.employee = new Employee[subordinates];
    }

    public Manager(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay,
            int subordinates) {
        super(age, name, gender, baseSalary, salaryPerDay);
        this.subordinates = subordinates;
        this.employee = subordinates > 0
                        ? new Employee[subordinates]
                        : new Employee[0];
    }

    @Override
    public double getSalary() {
        return subordinates < 1
               ? getBaseSalary()
               : getBaseSalary() + getBonus(0.03);
    }

    protected double getBonus(double percent) {
        return BigDecimal.valueOf(getBaseSalary())
                         .multiply(new BigDecimal(subordinates).multiply(
                                 BigDecimal.valueOf(percent)))
                         .doubleValue();
    }

    @Override
    public double getSalary(Month[] monthArray) {
        double amountSalary = super.getSalary(monthArray);
        double bonusPercentage = subordinates * 0.01;
        amountSalary += amountSalary * bonusPercentage;
        return amountSalary + getSalary() * monthArray.length;
    }
}
