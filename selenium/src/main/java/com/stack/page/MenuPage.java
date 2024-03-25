package com.stack.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
    @FindBy(css = ".menu-button")
    private WebElement menuButton;

    @FindBy(linkText = "login")
    private WebElement loginLink;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        menuButton.click();
        loginLink.click();
    }
}
