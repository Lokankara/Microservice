package com.stack.oop;

class AA {
    protected int i;

    AA(int i) {
        this.i = i;
    }
}


class CC extends BB {
    CC(int i) {
        super(i);
    }
}

class Client {
    BB SomeMethod() {
        return new BB(5);
    }
}

class BB extends AA {
    public BB(int x, int y) {
        super(x);
        System.out.println(y);
    }

    BB(int x) {
        super(x + 1);
        System.out.println(x);
    }

    BB(int x, int y, int z) {
        this(x, y);
        System.out.println(x);
    }
}

class CpecificClient extends Client {
    public BB SomeMethod() {
        return new CC(5);
    }
}


abstract class Dog3 {
    void woof() {
    }
}


abstract class Dog5 {
    abstract void woof();
}


public class Main {
    public static void main(String[] args) {
        AA a = new AA(5);
        BB b = new BB(5, 6);
        CpecificClient c = new CpecificClient();
        System.out.println(c);
    }
}
