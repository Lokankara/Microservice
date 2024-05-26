package com.stack.automation.opencart.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartEmptyPage extends TopPart {
    private final static String OPTION_TITLE_NOT_FOUND_MESSAGE = "Shopping cart page title does not match.";
    private final static String OPTION_HEADER_NOT_FOUND_MESSAGE = "Shopping cart header does not match.";
    private final static String OPTION_URL_NOT_FOUND_MESSAGE = "Shopping cart page url is not loaded.";
    private final static String OPTION_NOT_EMPTY_MESSAGE = "Shopping cart is not empty.";
    private final static String EMPTY_MESSAGE = "Your shopping cart is empty!";
    private final static String PAGE_HEADER = "Shopping Cart";
    private final static String PAGE_TITLE = "Shopping Cart";
    private WebElement shoppingCartLabel;
    private WebElement cartMessageLabel;
    private WebElement continueButton;

    public ShoppingCartEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        shoppingCartLabel = findElementBy(By.cssSelector("#content > h1"));
        cartMessageLabel = findElementBy(By.cssSelector("#content > p"));
        continueButton = findElementBy(By.cssSelector("div#content div.float-end > a.btn.btn-primary"));
    }

    public String getShoppingCartHeaderLabelText() {

        return shoppingCartLabel.getText();
    }

    public String getEmptyCartMessageText() {

        return cartMessageLabel.getText();
    }

    public HomePage clickContinueButton() {
        continueButton.click();

        return new HomePage(getDriver());
    }

    public ShoppingCartEmptyPage checkShoppingCartPage() {
        Assertions.assertEquals(EMPTY_MESSAGE, getEmptyCartMessageText(),
                OPTION_NOT_EMPTY_MESSAGE);

        Assertions.assertEquals(PAGE_HEADER, getShoppingCartHeaderLabelText(),
                OPTION_HEADER_NOT_FOUND_MESSAGE);

        return this;
    }

    public ShoppingCartEmptyPage checkShoppingCartEmptyMessage() {
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("/cart"),
                OPTION_URL_NOT_FOUND_MESSAGE);

        Assertions.assertEquals(PAGE_TITLE, getDriver().getTitle(),
                OPTION_TITLE_NOT_FOUND_MESSAGE);

        return this;
    }
}
