package com.stack.model.company;

public record Address(
        String street,
        String city,
        String state,
        String postalCode,
        String zip) {

}
