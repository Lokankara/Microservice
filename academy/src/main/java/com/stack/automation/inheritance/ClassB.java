package com.stack.automation.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassB
        extends ClassA {

    public double i = 1.1;

    public void m4(){
        log.info(getClass().getSimpleName());
    }

    public static void m6(){
        log.info("B");
        ClassA.m6();
    }

    public void m8(){
        log.info(getClass().getSimpleName());
        super.m8();
    }

    public void m5() {
        log.info(getClass().getSimpleName());
    }
}
