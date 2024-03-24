package com.stack.model.action;

import org.openqa.selenium.WebElement;

public class TextAction implements StepAction{
    @Override
    public String execute(
            WebElement element,
            String text) {
        return element.getText();
    }
}
