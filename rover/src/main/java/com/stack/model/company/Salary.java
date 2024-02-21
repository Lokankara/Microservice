package com.stack.model.company;

import com.stack.model.time.Month;

public class Salary {

    private final Month[] months = new Month[12];

    public double getSum(Employee[] employeeArray) {
        double sum = 0;
        for (Employee employee : employeeArray) {
            sum += employee.getSalary(months);
        }
        return sum;
    }
}
