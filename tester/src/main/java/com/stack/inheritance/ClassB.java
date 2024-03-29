package com.stack.inheritance;

public class ClassB
        extends ClassA {

    public double i = 1.1;

    public void m4(){
        System.out.println(getClass().getSimpleName());
    }

    public static void m6(){
        System.out.println("B");
        ClassA.m6();
    }

    public void m8(){
        System.out.println(getClass().getSimpleName());
        super.m8();
    }

    public void m5() {
        System.out.println(getClass().getSimpleName());
    }
}
