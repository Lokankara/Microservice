package com.stack.model.action;

import org.openqa.selenium.WebElement;

public class AttributeAction
        implements StepAction {
    @Override
    public String execute(
            WebElement element,
            String attrName) {
        return element.getAttribute(attrName);
    }
}
