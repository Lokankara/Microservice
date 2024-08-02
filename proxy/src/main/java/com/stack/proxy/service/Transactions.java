package com.stack.proxy.service;

import java.lang.reflect.Method;

public class Transactions {

    public static void handleTxStartFor(Method method) {
        if (method.getAnnotation(MyTransactional.class) != null)
            System.out.println(method.getName() + ": start");
    }

    public static void handleTxStopFor(Method method) {
        if (method.getAnnotation(MyTransactional.class) != null)
            System.out.println(method.getName() + ": stop");
    }
}