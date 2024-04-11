package com.stack.automation.inheritance;

public class App {
    public static void main(String[] args) {
        A a = new B();
        a.m2();
        A.m1();
        System.out.println(" a.i=" + a.i);
    }
}
