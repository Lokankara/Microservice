package com.stack.model.company;

import com.stack.model.time.Month;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Employee extends Human {

    private double salaryPerDay;
    private double baseSalary;

    public Employee(
            int age,
            String name,
            Gender gender,
            double baseSalary) {
        super(name, age, gender);
        this.baseSalary = baseSalary;
    }

    public Employee(
            int age,
            String name,
            Gender gender,
            double baseSalary,
            double salaryPerDay) {
        super(name, age, gender);
        this.baseSalary = baseSalary;
        this.salaryPerDay = salaryPerDay;
    }

    public Employee() {
        super("Employee", 0, Gender.OTHER);
    }

    public double getSalary() {
        return baseSalary;
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
        return amount + getSalary() * monthArray.length;
    }

    public boolean isSameName(Employee employee) {
        return this.getName().equals(employee.getName());
    }
}
