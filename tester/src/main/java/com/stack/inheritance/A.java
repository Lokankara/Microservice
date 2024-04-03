package com.stack.inheritance;

public class A {
    int i = 1;
    public static void m1() {
        System.out.print(" A_m1:");
    }

    public void m2() {
        System.out.print("A_m2");
        m1();
    }
}
