package com.stack.automation.model;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountCreatedPage
        extends BasePage {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    private WebDriver driver;

    @FindBy(xpath = "//li/a/b")
    private WebElement loginName;

    @FindBy(css = "b")
    private WebElement accountCreatedText;

    @FindBy(linkText = "Continue")
    private WebElement continueLink;

    @SneakyThrows
    public void verifyAccountCreated(String expected) {
        Thread.sleep(1000);
        Assert.assertEquals(accountCreatedText.getText(), expected);
    }

    public void clickContinue() {
        continueLink.click();
    }

    public void verifyAccountLoginName(String value) {
        Assert.assertEquals(loginName.getText(), value);
    }
}
