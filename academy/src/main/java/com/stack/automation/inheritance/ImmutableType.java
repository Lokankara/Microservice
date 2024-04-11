package com.stack.automation.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImmutableType {
    public void work(String text){
        log.info(text);
        text = text + "String";
        log.info(text);
    }
}
