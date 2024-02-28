package com.stack.dao.exception;

public class SqlParseException
        extends RuntimeException {
    public SqlParseException(String string) {
        super(string);
    }
}
