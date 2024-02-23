package com.stack.model.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkerTest {

    @Test
    void testWorkerConstructor() {
        int age = 30;
        String name = "John";
        Gender gender = Gender.MALE;
        double salary = 50000.0;
        Worker worker = new Worker(age, name, gender, salary);
        assertEquals(age, worker.getAge());
        assertEquals(name, worker.getName());
        assertEquals(gender, worker.getGender());
        assertEquals(salary, worker.getSalary());
    }

}
