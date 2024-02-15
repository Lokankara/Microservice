package com.stack.model.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonTest {

    @ParameterizedTest(name = "age:{0}, gender:{1}, name:{2}")
    @ArgumentsSource(PersonArgumentsProvider.class)
    void testGetName(int age, Gender gender, String name, String expectedName, String string) {
        Person person = new Person(name, age, gender);
        assertNotNull(person);
        assertEquals(expectedName, person.getName());
        assertEquals(string, person.toString());
    }

    @ParameterizedTest(name = "age:{0}, gender:{1}, name:{2}")
    @ArgumentsSource(PersonArgumentsProvider.class)
    void testEqualsHashCode(int age, Gender gender, String name, String expectedName, String string) {
        Person person = new Person(name, age, gender);
        Person same = new Person(name, age, gender);
        Person jane = new Person("Jane", age, gender);
        Person older = new Person(name, age + 1, gender);
        Person woman = new Person(name, age, Gender.OTHER);

        assertEquals(expectedName, person.getName());
        assertEquals(string, person.toString());
        assertEquals(person, same);
        assertEquals(person, same);
        assertEquals(person.hashCode(), same.hashCode());
        assertNotNull(person);
        assertNotEquals(person, new Object());
        assertNotEquals(person, jane);
        assertNotEquals(person, older);
        assertNotEquals(person, woman);
    }
}
