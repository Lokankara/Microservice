package com.stack.model.license;

public class LicensePlateFactory {
    private final State prefix;
    private int nextNumber;

    public LicensePlateFactory(State prefix, int nextNumber) {
        this.prefix = prefix;
        this.nextNumber = nextNumber;
    }

    public LicensePlate makeNextPlate() {
        return new LicensePlate("%s-%d".formatted(prefix.getAbbreviation(), nextNumber++));
    }
}
