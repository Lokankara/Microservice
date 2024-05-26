package com.stack.automation.waits.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RowPage extends BasePage {

    @FindBy(css = "tbody tr td:nth-child(3)")
    private List<WebElement> cityCells;

    public RowPage(final WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCityCells() {
        return cityCells;
    }
}
