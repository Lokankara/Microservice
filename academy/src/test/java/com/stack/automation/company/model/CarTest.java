package com.stack.automation.company.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CarTest {

    @Test
    public void testCarMap() {
        Map<String, Car> cars = new HashMap<>();
        Car bob = new Car("Bob", LocalDate.of(2024, 2, 2));
        Car carl = new Car("Carl", LocalDate.of(2025, 2, 2));
        Car alice = new Car("Alice", LocalDate.of(2023, 2, 2));
        Car audi = new Car("Audi", LocalDate.of(2020, 2, 2));
        cars.put("alice", alice);
        cars.put("audi", audi);
        cars.put("carl", carl);
        cars.put("bob", bob);
        for (String key : cars.keySet()) {
            System.out.println(cars.get(key));
        }
        Assert.assertEquals(4, cars.keySet().size());
    }
}
