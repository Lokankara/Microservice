package com.stack.model.gym;

import lombok.Getter;

@Getter
public enum Role {
    TERMINATOR(100),
    ANDROID(50),
    BEEFCAKE(30),
    AMOEBA(10);

    private final int capacity;

    Role(int capacity) {
        this.capacity = capacity;
    }
}
