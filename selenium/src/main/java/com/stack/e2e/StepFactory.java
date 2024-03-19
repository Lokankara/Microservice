package com.stack.e2e;

import com.stack.e2e.model.StepExecution;
import org.openqa.selenium.WebElement;

class StepFactory {
    static String execute(WebElement element, StepExecution step, String sentence) {
        return switch (step) {
            case CLICK -> {
                element.click();
                yield null;
            }
            case SEND -> {
                element.sendKeys(sentence);
                yield null;
            }
            case ATTRIBUTE -> element.getAttribute("value");
        };
    }
}
