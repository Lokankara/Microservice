package com.stack.model.action;

import org.openqa.selenium.WebElement;

public interface StepAction {
    String execute(WebElement element, String value);
}
