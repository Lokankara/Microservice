package com.stack.proxy.service;

public class DefaultCustomerService implements CustomerService {
    @Override
    public void create() {
        System.out.println((getClass().getName()));
    }
}
