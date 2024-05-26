package com.stack.automation.opencart.pages;

import com.stack.automation.opencart.component.NavigationComponent;
import com.stack.automation.opencart.data.Currencies;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {
    private static final String OPTION_TITLE_NOT_FOUND_MESSAGE = "HomePage Title is not loaded.";
    private static final String OPTION_URL_NOT_FOUND_MESSAGE = "HomePage url is not loaded.";
    private static final String PAGE_TITLE = "Your Store";
    private NavigationComponent navigationComponent;
    private WebElement container;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        navigationComponent = new NavigationComponent(getDriver());
        container = findElementBy(By.id("common-home"));
    }

    public HomePage chooseCurrency(Currencies currency) {
        clickCurrencyByPartialName(currency);
        return new HomePage(getDriver());
    }

    public ShoppingCartEmptyPage gotoShoppingCart() {
        return navigationComponent.clickShoppingCartLink();
    }

    public HomePage checkHomePage() {
        Assertions.assertTrue(
                getDriver().getCurrentUrl().contains("/home"),
                OPTION_TITLE_NOT_FOUND_MESSAGE);

        Assertions.assertEquals(
                PAGE_TITLE, getDriver().getTitle(),
                OPTION_URL_NOT_FOUND_MESSAGE);

        return this;
    }

    public boolean isLoaded() {

        return container.isDisplayed();
    }
}
