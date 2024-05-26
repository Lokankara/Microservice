package com.stack.automation.opencart.component;

import com.stack.automation.opencart.pages.ShoppingCartEmptyPage;
import com.stack.automation.opencart.pages.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationComponent extends TopPart {

    public NavigationComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private WebElement shoppingCartLink;

    private void initElements() {

        shoppingCartLink = findElementBy(By.xpath("//a[@title='Shopping Cart']"));
    }

    public ShoppingCartEmptyPage clickShoppingCartLink() {
        shoppingCartLink.click();

        return new ShoppingCartEmptyPage(getDriver());
    }
}
