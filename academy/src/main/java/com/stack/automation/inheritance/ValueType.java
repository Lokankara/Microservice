package com.stack.automation.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValueType {

    public void work(int i){
        log.info(String.valueOf(i));
        i++;
        log.info(String.valueOf(i));
    }
}
