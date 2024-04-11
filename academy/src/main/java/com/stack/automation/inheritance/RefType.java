package com.stack.automation.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RefType {

    public void work(StringBuilder sb){
        log.info(sb.toString());
        sb.append("RefType");
        log.info(sb.toString());
    }
}
