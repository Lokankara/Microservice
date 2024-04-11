package com.stack.automation.strings;

public class ArrayBuilder implements Builder{
    private static final int DEFAULT_CAPACITY = 16;
    private char[] buffer;
    private int size;

    public ArrayBuilder() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBuilder(int initialCapacity) {
        buffer = new char[initialCapacity];
        size = 0;
    }

    @Override
    public void append(String str) {
        ensureCapacity(size + str.length());
        for (int i = 0; i < str.length(); i++) {
            buffer[size++] = str.charAt(i);
        }
    }

    @Override
    public void insert(int index, String str) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        ensureCapacity(size + str.length());
        System.arraycopy(buffer, index, buffer, index + str.length(), size - index);

        for (int i = 0; i < str.length(); i++) {
            buffer[index + i] = str.charAt(i);
        }
        size += str.length();
    }

    @Override
    public void delete(int begin, int end) {
        if (begin < 0 || begin >= size || end <= begin || end > size) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }
        System.arraycopy(buffer, end, buffer, begin, size - end);
        size -= (end - begin);
    }

    @Override
    public int capacity() {
        return buffer.length;
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > buffer.length) {
            int newCapacity = Math.max(buffer.length * 2, minCapacity);
            char[] newBuffer = new char[newCapacity];
            System.arraycopy(buffer, 0, newBuffer, 0, size);
            buffer = newBuffer;
        }
    }

    @Override
    public void reverse() {
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            char temp = buffer[i];
            buffer[i] = buffer[j];
            buffer[j] = temp;
        }
    }

    @Override
    public String toString() {
        return new String(buffer, 0, size);
    }
}
