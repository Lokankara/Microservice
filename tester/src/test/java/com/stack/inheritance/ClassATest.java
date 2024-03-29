package com.stack.inheritance;

import com.stack.inheritance.ClassA;
import com.stack.inheritance.ClassB;
import org.junit.jupiter.api.Test;

class ClassATest {


    @Test
    void test() {
        //        ClassA a = new ClassA();
        //        a.m1();
        //        a.m2();
        //        a.m3();
        //        a.m4();
        //        a.m6();

        ClassA b = new ClassB();
        b.m1();
        b.m2();
        b.m3();
        b.m4();
        ClassA.m6();
        ClassB.m6();
        ((ClassB) b).m8();
        if (b instanceof ClassB) {
            ((ClassB) b).m5();
        }
    }
}
