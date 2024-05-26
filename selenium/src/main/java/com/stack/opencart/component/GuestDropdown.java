package com.stack.opencart.component;

import com.stack.opencart.tools.SearchStrategy;
import com.stack.opencart.tools.Search;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestDropdown {

    private WebDriver driver;
    private Search search;
    // register
    // return driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]"));
    //
    @Getter
    private WebElement register;
    // login
    @Getter
    private WebElement login;

    public GuestDropdown(WebDriver driver) {
        this.driver = driver;
        search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        //register = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]"));
        //login = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/login')]"));
        register = search.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]");
        login = search.xpath("//div[@id='top-links']//a[contains(@href,'account/login')]");
    }

    // Page Object

    public String getRegisterText() {
        return getRegister().getText();
    }

    public void clickRegister() {
        getRegister().click();
    }

    public String getLoginText() {
        return getLogin().getText();
    }

    public void clickLogin() {
        getLogin().click();
    }

    // Functional

    // Business Logic

}
