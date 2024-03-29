package com.stack.e2e;

import lombok.Getter;

@Getter
public class B extends A{
    private int j = 1;
    public void m1(){
        System.out.println(getClass().getSimpleName());
    }
}
