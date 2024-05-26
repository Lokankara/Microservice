package com.stack.automation.opencart.data;

import lombok.Getter;

@Getter
public enum Currencies {
    DEFAULT_CURRENCY("US Dollar", "$"),
    EURO("Euro", "€"),
    POUND_STERLING("Pound Sterling", "£"),
    US_DOLLAR("US Dollar", "$");

    private final String name;
    private final String symbol;

    private Currencies(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return name;
    }
}
