package com.stack.model.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectorTest {

    @Test
    void testManagerGetSalary() {
        Manager jack = new Manager(35, "Jack", Gender.MALE, 10000, 20, 10);
        Manager alice = new Manager(40, "Alice", Gender.FEMALE, 10000, 20,  0);
        Manager kate = new Manager(40, "Kate", Gender.FEMALE, 10000, 20,  1);
        Manager john = new Manager(31, "John", Gender.MALE, 10000, 20,  -1);
        assertEquals(13000, jack.getSalary(), 0.01);
        assertEquals(10000, alice.getSalary(), 0.01);
        assertEquals(10300, kate.getSalary(), 0.01);
        assertEquals(10000, john.getSalary(), 0.01);
    }

    @Test
    void testDirectorGetSalary() {
        Director bob = new Director(45, "Bob", Gender.MALE, 10000, 100, 10);
        Director emily = new Director(50, "Emily", Gender.FEMALE, 10000, 100, 0);
        Director kate = new Director(50, "Kate", Gender.FEMALE,10000, 100, 1);
        assertEquals(19000, bob.getSalary(), 0.01);
        assertEquals(10000, emily.getSalary(), 0.01);
        assertEquals(10900, kate.getSalary(), 0.01);
    }
}
