package com.stack.automation.company.model;

import java.time.LocalDate;

public record Customer(String name, LocalDate birthDate)
        implements Comparable<Customer> {

    @Override
    public String toString() {
        return String.format("User{name: %s, birthDate: %s}", name, birthDate);
    }

    @Override
    public int compareTo(Customer customer) {
        int birthDay = this.birthDate.compareTo(customer.birthDate);
        return birthDay != 0
               ? birthDay
               : this.name.compareTo(customer.name);
    }
}
