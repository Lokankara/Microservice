package com.stack.automation.waits.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TablePage extends BasePage {

    private final By header = By.id("uncontrolled-mode");
    private final By iframe = By.xpath("//h3[@id='uncontrolled-mode']/following-sibling::div[@class='embedded-demo'][1]//iframe");

    public TablePage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[contains(@class, 'MuiInputBase-root')])[last()-1]//input[contains(@class, 'MuiInputBase-input') and contains(@class, 'MuiInput-input') and contains(@class, 'Editor-input')]")
    private WebElement cityFilterInput;

    public CellPage filterCityByLetter(
            final String letter) {
        cityFilterInput.sendKeys(letter);
        return new CellPage(getDriver());
    }

    public TablePage scrollToTable() {
        scrollTo(header);
        return this;
    }

    private void scrollTo(final By header) {
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView(true);",
                getDriver().findElement(header));
    }

    public TablePage switchToIframe() {
        getWait().until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(iframe));
        return this;
    }

    public TablePage waitVisibilityOfElement() {
        getWait().until(ExpectedConditions
                .visibilityOfElementLocated(header));
        return this;
    }

    public boolean isUncontrolledMode() {
        WebElement mode = getDriver().findElement(header);
        return mode.isDisplayed() && mode.getText().contains("Uncontrolled Mode");
    }
}
