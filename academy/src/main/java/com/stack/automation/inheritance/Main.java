package com.stack.automation.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ImmutableType immutableType = new ImmutableType();
        RefType refType = new RefType();
        ValueType valueType = new ValueType();
        String text = "immutableType ";
        immutableType.work(text);
        log.info(text);
        StringBuilder sb = new StringBuilder("123 ");
        refType.work(sb);
        log.info(String.valueOf(sb));
        int i = 10;
        valueType.work(i);
        log.info(String.valueOf(i));
    }
}
