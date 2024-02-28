package com.stack.model.company;

import com.stack.model.time.Month;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class Employee
        extends Human {

    private double salaryPerDay;
    private double baseSalary;
    private int subordinates;
    private double percent;

    protected Employee(
            int age,
            String name,
            Gender gender) {
        super(age, name, gender);
    }

    protected Employee(
            int age,
            String name,
            Gender gender,
            double baseSalary) {
        super(age, name, gender);
        this.baseSalary = baseSalary;
    }

    protected Employee(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay) {
        super(age, name, gender);
        this.baseSalary = baseSalary;
        this.salaryPerDay = salaryPerDay;
    }

    protected Employee(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay,
            int subordinates) {
        super(age, name, gender);
        this.salaryPerDay = salaryPerDay;
        this.baseSalary = baseSalary;
        this.subordinates = subordinates;
    }

    abstract double getSalary();

    protected double getPercent() {
        return percent;
    }

    protected double getBonus(double percent) {
        return BigDecimal.valueOf(getBaseSalary())
                         .multiply(new BigDecimal(getSubordinates()).multiply(
                                 BigDecimal.valueOf(percent)))
                         .doubleValue();
    }

    double getSalary(Month[] monthArray) {
        double amount = 0;
        if (monthArray == null) {
            return amount;
        }
        for (Month month : monthArray) {
            if (month != null) {
                amount += month.workingDays() * salaryPerDay;
            }
        }
        amount += getSalary() * monthArray.length;

        return subordinates < 1
               ? amount
               : amount + getBonus(0.01) * monthArray.length;
    }

    public boolean isSameName(Employee employee) {
        return this.getName()
                   .equals(employee.getName());
    }
}
