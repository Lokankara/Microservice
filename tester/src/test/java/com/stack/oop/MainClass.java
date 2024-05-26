package com.stack.oop;

interface I {
}

class A implements I {
}

class B extends A {
}

class C extends B {
}

public class MainClass {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();
//        a = I(b);
        a = (A) b;

        b = (B) a;

//        b = a;
        a = b;
        System.out.println(b);
    }
}
