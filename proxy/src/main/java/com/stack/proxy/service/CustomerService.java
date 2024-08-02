package com.stack.proxy.service;

public interface CustomerService {

    @MyTransactional
    void create();
}