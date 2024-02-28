package com.stack.dao.exception;

public class SqlArgumentException
        extends RuntimeException {
    public SqlArgumentException(String message) {
        super(message);
    }
}
