package com.stack.e2e;

import lombok.Getter;

@Getter
public class A {
    private final int i = 11;

    public void m1(){
        System.out.println(getClass().getSimpleName());
    }
}
