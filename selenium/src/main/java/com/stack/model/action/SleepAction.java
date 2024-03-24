package com.stack.model.action;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class SleepAction
        implements StepAction {
    @Override
    public String execute(
            WebElement element,
            String millis) {
        try {
            Thread.sleep(Long.parseLong(millis));
        } catch (InterruptedException e) {
            Thread.currentThread()
                  .interrupt();
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
