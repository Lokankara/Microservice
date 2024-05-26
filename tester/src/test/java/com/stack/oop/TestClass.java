package com.stack.oop;

class BaseClass {
    BaseClass() {
    }

    BaseClass(int k) {
    }
}

class DerivedClass extends BaseClass {
    public DerivedClass(int param1, int param2) {
        System.out.println(param1);
        System.out.println(param2);
    }

    public DerivedClass(int m) {
        super(m);
    }
}


class Super {
    public int getNumber(int a) {
        return a;
    }
}

public class TestClass extends Super {
    public int getNumber(int a, int b) {
        return 5;
    }

    public static void main(String[] args) {
        System.out.println(new TestClass().getNumber(4));
        Base s1 = new Base();
//        Derived s2 = new Derived();
//        s1 = s2;
//        s2 = s1;
//        s2 = (Derived) s1;

        System.out.println(s1);
        Base b = new Derived();
        System.out.println(b);
    }
}

class Base {
    public short getValue() {
        return 100;
    }
}

class Derived extends Base {
    public short getValue() {
        return 5;
    }
}
