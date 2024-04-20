package com.stack.luma.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//div[@class='box-content']//p")
    private WebElement accountInfoParagraph;

    @FindBy(xpath = "//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
    private WebElement messageDivElement;

    protected AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountInfoText() {
        return accountInfoParagraph.getText();
    }

    private void verify(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public void assertParagraphText(String expectedText) {
        verify(getAccountInfoText(), expectedText);
    }

    public void assertMessageDivText(String expectedText) {
        verify(getMessageDivText(), expectedText);
    }
    public String getMessageDivText() {
        return messageDivElement.getText();
    }
}
