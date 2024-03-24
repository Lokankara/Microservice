package com.stack.model;

import org.openqa.selenium.WebElement;

public record StepTuple(WebElement element, StepExecution step, String value) {
}
