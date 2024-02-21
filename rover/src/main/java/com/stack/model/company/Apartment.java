package com.stack.model.company;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Apartment {
    private int bedrooms;
    private Address address;
    private int price;

    public Apartment(
            int bedrooms,
            Address address,
            int price) {
        this.bedrooms = bedrooms;
        this.address = address;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return bedrooms == apartment.bedrooms
                && price == apartment.price
                && Objects.equals(address, apartment.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bedrooms, address, price);
    }

    @Override
    public String toString() {
        return "Apartment{bedrooms=%d, address=%s, price=%d}".formatted(
                bedrooms, address, price);
    }
}
