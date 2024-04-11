package com.stack.automation.collection;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
public class Manager extends Employee {

    private final double coefficient;

    public Manager(
            String name,
            int experience,
            BigDecimal basePayment,
            double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    @Override
    public BigDecimal getBasePayment() {
        return super.getBasePayment().multiply(BigDecimal.valueOf(coefficient));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(coefficient, manager.coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }
}
