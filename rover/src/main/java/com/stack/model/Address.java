package com.stack.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Address {

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String zip;

    public Address(
            String street,
            String city,
            String state,
            String postalCode,
            String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.zip = zip;
    }
}
