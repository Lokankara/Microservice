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
public abstract class BaseEmployee extends Human {

    private double salaryPerDay;
    private double baseSalary;
    private int subordinates;
    private double percent = 0;

    protected BaseEmployee(
            int age,
            String name,
            Gender gender) {
        super(age, name, gender);
    }

    protected BaseEmployee(
            int age,
            String name,
            Gender gender,
            double baseSalary) {
        super(age, name, gender);
        this.baseSalary = baseSalary;
    }

    protected BaseEmployee(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay) {
        super(age, name, gender);
        this.salaryPerDay = salaryPerDay;
        this.baseSalary = baseSalary;
    }

    protected BaseEmployee(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay,
            int subordinates) {
        super(age, name, gender);
        this.subordinates = subordinates;
        this.salaryPerDay = salaryPerDay;
        this.baseSalary = baseSalary;
    }

    abstract double getSalary();

    protected double getPercent(){
        return percent;
    }

    protected double getSalary(Month[] monthArray) {
        if (monthArray == null) {
            return 0;
        }
        double amount = getAmount(monthArray);

        return getSubordinates() < 1
               ? amount
               : amount + getBonus(0.01) * monthArray.length;
    }

    private double getAmount(Month[] monthArray) {
        double amount = 0;

        for (Month month : monthArray) {
            if (month != null) {
                amount += month.workingDays() * getSalaryPerDay();
            }
        }
        amount += getSalary() * monthArray.length;
        return amount;
    }

    protected double getBonus(double percent) {
        return BigDecimal.valueOf(getBaseSalary())
                         .multiply(new BigDecimal(getSubordinates())
                                           .multiply(BigDecimal.valueOf(percent)))
                         .doubleValue();
    }
}
