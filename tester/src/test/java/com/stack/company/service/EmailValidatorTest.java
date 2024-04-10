package com.stack.company.service;

import com.stack.company.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class EmailValidatorTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @ParameterizedTest(name = "Valid email: {0}")
    @ArgumentsSource(ValidEmailProvider.class)
    void testValidEmail(String actual) {
        user.setEmail(actual);
        String expected = user.getEmail();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "Invalid Email: {0}")
    @ArgumentsSource(InvalidEmailProvider.class)
    void testValidateEmailValidData(String actual) {
        Assertions.assertThrows(EmailArgumentException.class,
                                () -> user.setEmail(actual),
                                String.format("Invalid Email: %s", actual));
    }

    @Test
    void testNullEmail() {
        Assertions.assertThrows(
                EmailArgumentException.class,
                () -> user.setEmail(null));
    }
}
