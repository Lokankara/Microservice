package com.stack.model.company;

import com.stack.model.time.Month;

public class Salary {

    private final Month[] months = new Month[12];

    public double getSum(BaseEmployee[] employeeArray) {
        double sum = 0;
        for (BaseEmployee employee : employeeArray) {
            sum += employee.getSalary(months);
        }
        return sum;
    }
}
