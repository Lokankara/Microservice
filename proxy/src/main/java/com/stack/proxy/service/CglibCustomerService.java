package com.stack.proxy.service;

public class CglibCustomerService {

    @MyTransactional
    public void create() {
        System.out.println(getClass().getName());
    }
}
