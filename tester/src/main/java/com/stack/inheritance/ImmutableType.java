package com.stack.inheritance;

public class ImmutableType {
    public void work(String text){
        System.out.println(text);
        text = text + "String";
        System.out.println(text);
    }
}
