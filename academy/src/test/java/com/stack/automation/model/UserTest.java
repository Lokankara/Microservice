package com.stack.automation.model;

import exception.EmailArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    private User bob;
    private User user;
    private User alice;

    @BeforeEach
    void setUp() {
        user = new User();
        bob = new User("bob.test@google.com");
        alice = new User("alice.test@google.com");
    }

    @Test
    @DisplayName("Test equals and hashCode with same email: Given two users with the same email, when comparing with equals, then they should be equal and have the same hash code")
    void testEqualsAndHashCodeWithSameEmail() {
        user.setEmail("bob.test@google.com");
        assertEquals(user, bob);
        assertEquals(bob, user);
        assertEquals(user.hashCode(), bob.hashCode());
    }

    @Test
    @DisplayName("Test equals and hashCode with different emails: Given two users with different emails, when comparing with equals, then they should not be equal and have different hash codes")
    void testEqualsAndHashCodeWithDifferentEmails() {

        assertNotEquals(bob, alice);
        assertNotEquals(alice, bob);
        assertNotEquals(bob, user);
        assertNotEquals(alice, user);

        assertNotEquals(user.hashCode(), bob.hashCode());
        assertNotEquals(bob.hashCode(), alice.hashCode());
        assertNotEquals(user.hashCode(), alice.hashCode());
    }

    @Test
    @DisplayName("Test equals handles null and different class objects: Given a user object, when comparing with null and a different class object, then it should return false")
    void testEqualsHandlesNullAndDifferentClassObjects() {

        assertNotEquals(null, bob);
        assertNotEquals(null, alice);
        assertNotEquals(alice, bob);
    }

    @Test
    @DisplayName("Test default constructor: When creating a user with default constructor, then email should be null")
    void testDefaultConstructor() {

        assertNull(user.getEmail());
    }

    @Test
    @DisplayName("Method getEmail(): When getting email of a user, then it should return the correct email")
    void testGetEmail() {

        assertEquals("bob.test@google.com", bob.getEmail());
    }

    @Test
    @DisplayName("Method setEmail(): Given a valid email, when setting email of a user, then it should be set correctly")
    void testSetEmailWithValidEmail() {

        user.setEmail("user.test.123@google.com");

        assertEquals("user.test.123@google.com", user.getEmail());
    }

    @Test
    @DisplayName("Method setEmail(): Given an invalid email, when setting email of a user, then it should throw IllegalArgumentException")
    void testSetEmailWithInvalidEmail() {

        assertThrows(EmailArgumentException.class,
                     () -> user.setEmail("invalid.email"));
        assertNull(user.getEmail());
    }
}
