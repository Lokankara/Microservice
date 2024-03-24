package com.stack.model;

public class StepLocator {

    private StepLocator(){}

    public static final String h2Tag = "h2";
    public static final String dropId = "drop-header";
    public static final String listId = "certificates-list";
    public static final String aHoliday = "//a[text()='Holiday']";
    public static final String searchPlaceholder = "//input[@placeholder='Search by item name']";
    public static final String certificateCard = "//div[@class='certificate-card' and not(contains(@style, 'display: none'))]";
}
