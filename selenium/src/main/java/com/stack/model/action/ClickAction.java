package com.stack.model.action;

import org.openqa.selenium.WebElement;

public class ClickAction
        implements StepAction {

    @Override
    public String execute(
            WebElement element,
            String text) {
        element.click();
        return null;
    }
}
