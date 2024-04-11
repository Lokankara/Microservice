package com.stack.automation.company.validator;

public class EmailArgumentException
        extends RuntimeException {
    public EmailArgumentException(String message) {
        super(message);
    }

    public EmailArgumentException(
            final String message, final String value) {
        super(String.format("%s %s", message, value));
    }
}
