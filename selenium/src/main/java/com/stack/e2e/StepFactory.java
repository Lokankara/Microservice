package com.stack.e2e;

import org.openqa.selenium.WebElement;

class StepFactory {
    static String performStep(WebElement element, StepExecution step, String sentence) {
        switch (step) {
            case CLICK:
                element.click();
                return null;
            case SEND:
                element.sendKeys(sentence);
                return null;
            case ATTRIBUTE:
                return element.getAttribute("value");
            default:
                return null;
        }
    }
}
