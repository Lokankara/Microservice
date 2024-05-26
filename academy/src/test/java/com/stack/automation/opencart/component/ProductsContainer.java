package com.stack.automation.opencart.component;

import com.stack.automation.opencart.exceptions.ComponentNoFoundException;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductsContainer {

    public final String PRODUCT_NOT_FOUND = "There is no product that matches the search criteria.";
    private static final String PRODUCT_COMPONENT_CSS_SELECTOR = "div#content div.col";
    protected WebDriver driver;
    @Getter
    private List<ProductComponent> productComponents;

    public ProductsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        productComponents = driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSS_SELECTOR))
                .stream()
                .map(ProductComponent::new)
                .toList();
    }

    public int getProductComponentsCount() {
        return getProductComponents().size();
    }

    public List<String> getProductComponentNames() {
        return getProductComponents()
                .stream()
                .map(ProductComponent::getNameText)
                .toList();
    }

    public ProductComponent getProductComponentByName(String productName) {
        return getProductComponents()
                .stream()
                .filter(current -> current.getNameText()
                        .equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new ComponentNoFoundException(
                        String.format("ProductName: %s not Found.", productName)));
    }

    public String getProductComponentPriceByName(String productName) {
        return getProductComponentByName(productName).getPriceText();
    }

    public String getProductComponentDescriptionByName(String productName) {
        return getProductComponentByName(productName).getPartialDescriptionText();
    }

    public void clickProductComponentAddToCartButtonByName(String productName) {
        getProductComponentByName(productName).clickAddToCartButton();
    }

    public void clickProductComponentAddToWishButtonByName(String productName) {
        getProductComponentByName(productName).clickAddToWishButton();
    }
}
