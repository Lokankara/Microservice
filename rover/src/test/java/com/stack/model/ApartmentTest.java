package com.stack.model;

import com.stack.model.company.Apartment;
import com.stack.model.provider.ApartmentArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApartmentTest {

    @ParameterizedTest
    @ArgumentsSource(ApartmentArgumentsProvider.class)
    void testEquals(Apartment a, Apartment b, boolean expected) {
        assertEquals(expected, a.equals(b));
    }

    @ParameterizedTest
    @ArgumentsSource(ApartmentArgumentsProvider.class)
    void testHashCode(Apartment a, Apartment b, boolean expected) {
        assertEquals(expected, a.hashCode() == b.hashCode());
    }

    @ParameterizedTest
    @ArgumentsSource(ApartmentArgumentsProvider.class)
    void testGetOnlyNY(Apartment a, Apartment b, boolean expected, boolean isNY) {
        assertEquals(isNY, "New York".equals(a.getAddress().city()));
    }

    @ParameterizedTest
    @ArgumentsSource(ApartmentArgumentsProvider.class)
    void testGetOnlyCheepApartments(Apartment a, Apartment b, boolean expected, boolean cheep) {
        assertEquals(cheep, a.getPrice() < 2001);
    }
}
