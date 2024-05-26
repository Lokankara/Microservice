package com.stack.automation.exception;

public class EmailArgumentException
        extends IllegalArgumentException {
    public EmailArgumentException(
            final String message) {
        super(message);
    }

    public EmailArgumentException(
            final String message, final String value) {
        super(String.format("%s %s", message, value));
    }
}
