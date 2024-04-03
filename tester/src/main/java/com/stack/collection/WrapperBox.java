package com.stack.collection;

public class WrapperBox {
    private final Box<String> box = new Box<>();

    public String getBox() {
        return box.get();
    }

    public void set(String text) {
        this.box.set(text);
    }
}
