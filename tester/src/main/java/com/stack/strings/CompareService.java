package com.stack.strings;

public interface CompareService {

    boolean equals(Object obj);

    public boolean equalsIgnoreCase(String a, String b);

    int compareTo(String s);

    int compareToIgnoreCase(String s);

    boolean contentEquals(StringBuilder sb);
}
