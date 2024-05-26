package com.stack.automation.opencart.pages;

import com.stack.automation.opencart.component.DropdownComponent;
import com.stack.automation.opencart.data.Currencies;
import com.stack.automation.opencart.exceptions.ComponentNoFoundException;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopPart {
    protected final String OPTION_NULL_MESSAGE = "DropdownComponent is null";
    protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    protected final String LIST_CURRENCIES_CSS_SELECTOR = "form#form-currency ul.dropdown-menu li";
    private DropdownComponent dropdownComponent;
    @Getter
    private WebElement searchTopField;
    @Getter
    private WebElement currency;
    private final WebDriver driver;

    public TopPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        currency = findElementBy(By.cssSelector("a.dropdown-toggle[href='#']"));
        searchTopField = findElementBy(By.name("search"));
    }

    protected WebElement findElementBy(By locator) {

        return driver.findElement(locator);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public String getCurrencyText() {
        return getCurrency().getText();
    }

    public void clickCurrency() {
        getCurrency().click();
    }

    public void clickSearchTopField() {
        getSearchTopField().click();
    }

    protected DropdownComponent getDropdownComponent() {
        if (dropdownComponent == null) {
            throw new ComponentNoFoundException(OPTION_NULL_MESSAGE);
        }
        return dropdownComponent;
    }

    private DropdownComponent createDropdownComponent(By searchLocator) {
        dropdownComponent = new DropdownComponent(driver, searchLocator);
        return getDropdownComponent();
    }

    private void clickDropdownComponentByPartialName(String optionName) {
        if (!getDropdownComponent().isExistDropdownOptionByPartialName(optionName)) {
            throw new ComponentNoFoundException(
                    String.format(OPTION_NOT_FOUND_MESSAGE, optionName,
                            getDropdownComponent().getListOptionsText().toString()));
        }
        getDropdownComponent().clickDropdownOptionByPartialName(optionName);
        dropdownComponent = null;
    }

    private void openCurrencyDropdownComponent() {
        clickSearchTopField();
        clickCurrency();
        createDropdownComponent(By.cssSelector(LIST_CURRENCIES_CSS_SELECTOR));
    }

    protected void clickCurrencyByPartialName(Currencies optionName) {
        openCurrencyDropdownComponent();
        clickDropdownComponentByPartialName(optionName.toString());
    }
}
