package com.stack.automation.opencart.component;

import com.stack.automation.opencart.exceptions.ComponentNoFoundException;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownComponent {
    private final static String OPTION_NAME_NOT_FOUND = "OptionName not Found.";
    @Getter
    private List<WebElement> listOptions;
    protected WebDriver driver;

    public DropdownComponent(WebDriver driver, By searchLocator) {
        this.driver = driver;
        initElements(searchLocator);
    }

    private void initElements(By searchLocator) {
        listOptions = driver.findElements(searchLocator);
    }

    public WebElement getDropdownOptionByPartialName(String optionName) {
        return getListOptions()
                .stream()
                .filter(current -> current.getText().toLowerCase().contains(optionName.toLowerCase()))
                .findFirst().orElseThrow(() -> new ComponentNoFoundException(OPTION_NAME_NOT_FOUND));
    }

    public List<String> getListOptionsText() {
        return getListOptions()
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public boolean isExistDropdownOptionByPartialName(String optionName) {
        return getListOptionsText()
                .stream()
                .anyMatch(current -> current.toLowerCase().contains(optionName.toLowerCase()));
    }

    public void clickDropdownOptionByPartialName(String optionName) {
        getDropdownOptionByPartialName(optionName).click();
    }
}
