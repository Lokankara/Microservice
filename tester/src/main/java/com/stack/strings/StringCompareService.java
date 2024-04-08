package com.stack.strings;

public class StringCompareService implements CompareService {

    @Override
    public boolean equalsIgnoreCase(String a, String b) {
        return b != null
               && b.equalsIgnoreCase(a);
    }

    @Override
    public int compareTo(String s) {
        return s == null
               ? -2 : this.toString().compareTo(s);
    }

    @Override
    public int compareToIgnoreCase(String s) {
        return s == null
               ? -2 : this.toString().compareToIgnoreCase(s);
    }

    @Override
    public boolean contentEquals(StringBuilder sb) {
        return sb != null
               && this.toString().contentEquals(sb);
    }
}
