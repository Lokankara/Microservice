package com.stack.proxy.service;

public class ForwardingCustomerService
        implements CustomerService {

    private final CustomerService customerService;

    ForwardingCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void create() {
        System.out.println("create: start");
        this.customerService.create();
        System.out.println("create: stop");
    }
}
