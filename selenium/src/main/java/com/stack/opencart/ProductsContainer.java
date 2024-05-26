package com.stack.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsContainer {

    private WebElement element;
    public ProductsContainer(WebElement element){
        this.element = element;
    }

    public String getProductName(){
        return element.findElement(By.xpath(".//h4/a[contains(@href,'product')]")).getText();
    }
}
