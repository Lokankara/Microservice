package com.stack.e2e.model;

import org.openqa.selenium.By;

public record StepTuple(By by, StepExecution step) {
}
