package com.stack.model.company;

import com.stack.model.provider.PersonArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonTest {

    @ParameterizedTest(name = "age:{0}, gender:{1}, name:{2}")
    @ArgumentsSource(PersonArgumentsProvider.class)
    void testGetName(int age, Gender gender, String name, String expectedName, String string) {
        Person person = new Person(age, name, gender);
        assertNotNull(person);
        assertEquals(expectedName, person.getName());
        assertEquals(string, person.toString());
    }

    @ParameterizedTest(name = "age:{0}, gender:{1}, name:{2}")
    @ArgumentsSource(PersonArgumentsProvider.class)
    void testEqualsHashCode(int age, Gender gender, String name, String expectedName, String string) {
        Person person = new Person(age, name, gender);
        Person same = new Person(age, name, gender);
        Person jane = new Person(age, "Jane", gender);
        Person older = new Person(age + 1, name, gender);
        Person woman = new Person(age, name, Gender.UNKNOWN);

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
