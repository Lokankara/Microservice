package com.stack.automation.strings;

public interface Builder {

    void append(String str);

    void insert(int index, String str);

    void delete(int begin, int end);

    int capacity();

    void ensureCapacity(int minCapacity);

    void reverse();
}
