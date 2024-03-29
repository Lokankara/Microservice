package com.stack.inheritance;

public class ClassA {

    public double i = 1;

    public void m1(){
        System.out.println(i);
    }

    public void m2(){
        System.out.printf("%s %s%n", getClass().getSimpleName(), i);
    }

    public void m3(){
        System.out.printf("%s %s%n", getClass().getSimpleName(), i);
        m4();
    }
    public void m4(){
        System.out.printf("%s %s%n", getClass().getSimpleName(), i);
    }

    public static void m6(){
        System.out.println("A");
    }

    protected void m8(){
        System.out.printf("%s %s%n", getClass().getSimpleName(), i);
    }
}
