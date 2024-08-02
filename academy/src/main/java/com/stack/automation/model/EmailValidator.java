package com.stack.automation.model;

import com.stack.automation.exception.EmailArgumentException;

public class EmailValidator {

    private EmailValidator() {
    }

    private static final String USERNAME_PATTERN = "^(?!.*\\.\\.)[a-zA-Z0-9][a-zA-Z0-9.]{5,29}(?<!\\.)$";
    private static final String DOMAIN_PATTERN = "^(([a-zA-Z0-9]+[a-zA-Z0-9\\-]*)\\.)*([a-zA-Z0-9]+[a-zA-Z0-9\\-]*)(?<!-)\\.[a-zA-Z]{2,}$";

    /**
     * Required field cannot be left blank.
     * username cannot contain consecutive periods (.)
     * username must be between 6 and 30 characters long.
     * only letters (a-z), numbers (0-9), and periods (.) are allowed.
     * the last character of your username must be an ascii letter (a-z) or number (0-9)
     * the first character of your username must be an ascii letter (a-z) or number (0-9).
     * usernames of 8 or more characters must include at least one alphabetical character (a-z)
     * */
    public static void checkEmail(final String email) {

        if (email == null || email.isEmpty()) {
            throw new EmailArgumentException(
                    "Required Email address field cannot be left blank or null.");
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new EmailArgumentException("Invalid Email:", email);
        }

        validateUsername(parts[0]);
        validateDomain(parts[1]);
    }

    private static void validateUsername(final String username) {

        if (!username.matches(USERNAME_PATTERN)) {
            throw new EmailArgumentException("Invalid username: " + username);
        }

        if (username.length() > 9 && !username.matches(".*[a-zA-Z].*")) {
            throw new EmailArgumentException(
                    "Username must include at least one alphabetical character (a-z).");
        }
    }

    private static void validateDomain(final String domain) {

        if (domain.isEmpty() || domain.length() > 255) {
            throw new EmailArgumentException(
                    "Invalid length of domain: ", domain);
        }

        if (!domain.matches(DOMAIN_PATTERN)) {
            throw new EmailArgumentException("Invalid domain: ", domain);
        }
    }
}
