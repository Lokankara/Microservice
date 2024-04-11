package com.stack.automation.collection;

import lombok.Getter;

public class Box<T> {

    private T t;

    @Getter
    private Object obj;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
