package com.stack.automation.opencart.component;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public class ProductComponent {

    private final WebElement productLayout;
    private WebElement partialDescription;
    private WebElement addToCompareButton;
    private WebElement addToCartButton;
    private WebElement addToWishButton;
    private WebElement name;
    private WebElement price;

    public ProductComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        initElements();
    }

    private void initElements() {
        name = productLayout.findElement(By.cssSelector("h4 a"));
        partialDescription = productLayout.findElement(By.cssSelector("h4 + p"));
        price = productLayout.findElement(By.cssSelector(".price"));
        addToCartButton = productLayout.findElement(By.cssSelector(".fas.fa-shopping-cart"));
        addToWishButton = productLayout.findElement(By.cssSelector(".fas.fa-heart"));
        addToCompareButton = productLayout.findElement(By.cssSelector(".fas.fa-exchange-alt"));
    }

    public String getNameText() {
        return getName().getText();
    }

    public void clickName() {
        getName().click();
    }

    public String getPartialDescriptionText() {
        return getPartialDescription().getText();
    }

    public String getPriceText() {
        return getPrice().getText();
    }

    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    public void clickAddToWishButton() {
        getAddToWishButton().click();
    }

    public void clickAddToCompareButton() {
        getAddToCompareButton().click();
    }
}
