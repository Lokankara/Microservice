package com.stack.automation.inheritance;

public class B extends A {
    double i = 1.1;
    public static void m1() {
        System.out.print(" B_m1:");
    }

    public void m2() {
        System.out.print(" B_m2");
        m1();
    }
}
