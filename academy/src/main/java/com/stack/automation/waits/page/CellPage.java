package com.stack.automation.waits.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CellPage extends BasePage {

    protected CellPage(final WebDriver driver) {
        super(driver);
    }

    public List<String> getTextFromCells(
            final List<WebElement> cells) {
        return cells.stream()
                .map(WebElement::getText)
                .toList();
    }
}
