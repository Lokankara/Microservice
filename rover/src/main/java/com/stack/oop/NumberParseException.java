package com.stack.oop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberParseException
        extends RuntimeException {
    public NumberParseException(String message) {
        log.error(message);
    }
}
