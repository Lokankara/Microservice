package com.stack.strings;

public interface Regex {
    boolean compile();
    boolean matches();
    boolean matcher();
    boolean lookingAt();
    boolean reset();
    boolean find();
}
