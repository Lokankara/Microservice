package com.stack.automation.company.model;

import java.time.LocalDate;

public record Car(String name, LocalDate release)
        implements Comparable<Car> {
    @Override
    public int compareTo(Car car) {
        int birthDay = this.release.compareTo(car.release);
        return birthDay != 0
               ? birthDay
               : this.name.compareTo(car.name);
    }

    @Override
    public String toString() {
        return String.format(
                "Car{name='%s', release=%s}",
                name, release);
    }
}
