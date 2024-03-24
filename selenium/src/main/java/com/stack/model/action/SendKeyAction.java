package com.stack.model.action;

import org.openqa.selenium.WebElement;

public class SendKeyAction
        implements StepAction {
    @Override
    public String execute(
            WebElement element,
            String text) {
        element.sendKeys(text);
        return null;
    }
}
