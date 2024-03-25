package com.stack.automation.model;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DeleteAccountPage extends BasePage {

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    private WebDriver driver;

    @FindBy(css = "b")
    private WebElement accountDeletedText;

    @FindBy(linkText = "Continue")
    private WebElement continueLink;

    @FindBy(linkText = "Delete Account")
    private WebElement deleteLink;

    public String getAccountDeletedText() {
        return accountDeletedText.getText();
    }

    public void clickContinueLink() {
        continueLink.click();
    }

    public void clickDeleteLink() {
        deleteLink.click();
    }

    @SneakyThrows
    public void verifyAccountDeleted(String expected) {
        Thread.sleep(1000);
        Assert.assertEquals(accountDeletedText.getText(), expected);
    }
}
