package com.stack.opencart;

import com.stack.opencart.component.GuestDropdown;
import com.stack.opencart.component.LoggedDropdown;
import com.stack.opencart.component.MenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class TopPart {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final String OPTION_NULL_MESSAGE = "DropdownComponent is null";
    protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    protected final String PAGE_DO_NOT_EXIST = "Page do not exist!!!";
    protected final String TAG_ATTRIBUTE_VALUE = "value";
    protected final String TAG_ATTRIBUTE_SRC = "src";
    protected final String LIST_CURRENCIES_CSSSELECTOR = "form#form-currency ul.dropdown-menu li";
    protected final String DROPDOWN_MYACCOUNT_CSSSELECTOR = ".dropdown-menu-right li";

    protected WebDriver driver;
    private WebElement currency;
    private WebElement myAccount;
    private WebElement wishList;
    private WebElement shoppingCart;
    private WebElement logo;
    private WebElement searchTopField;
    private WebElement searchTopButton;
    private WebElement cartButton;

    protected TopPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    List<MenuComponent> menu;
    private GuestDropdown dropdownGuest;
    private LoggedDropdown dropdownLogged;


    private void initElements() {
        currency = driver.findElement(By.cssSelector("a.dropdown-toggle[href='#']"));
        myAccount = driver.findElement(By.cssSelector("li.list-inline-item > div > a.dropdown-toggle"));
        logo = driver.findElement(By.cssSelector("#logo a"));
        searchTopField = driver.findElement(By.name("search"));
        searchTopButton = driver.findElement(By.cssSelector("button.btn.btn-default"));
        cartButton = driver.findElement(By.cssSelector("#cart > button"));
    }

//    protected DropdownComponent(){}

//    protected GuestDropdown createGuestDropdown(){
//        return new GuestDropdown(driver);
//    }

    protected LoggedDropdown createGuestDropdown(){
        return new LoggedDropdown(driver);
    }
}
