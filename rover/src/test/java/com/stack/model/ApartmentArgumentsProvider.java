package com.stack.model;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ApartmentArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)
            throws Exception {

        Address nnyAddress = new Address("123 Main St", "New York", "NY", "10001", "12345");
        Address nyAddress = new Address("456 Oak St", "New York", "NY", "10002", "54321");
        Address sfAddress = new Address("789 Elm St", "San Francisco", "CA", "94107", "67890");
        Address laAddress = new Address("101 Pine St", "Los Angeles", "CA", "90001", "98765");

        Apartment nny = new Apartment(2, nnyAddress, 2000);
        Apartment ny = new Apartment(2, nyAddress, 2000);
        Apartment sf = new Apartment(3, sfAddress, 2500);
        Apartment la = new Apartment(2, laAddress, 1500);

        return Stream.of(Arguments.of(nny, ny, false, true),
                         Arguments.of(ny, ny, true, true),
                         Arguments.of(ny, sf, false, true),
                         Arguments.of(sf, la, false, false),
                         Arguments.of(ny, la, false, true));
    }
}
