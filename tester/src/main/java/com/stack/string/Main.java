package com.stack.string;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String s = "1";
        work(s);
        System.out.print(s);
        System.out.println();
        String str1 = "Java";
        String str2 = "Java";
        str2 = new String("Java");
        str1 = new String("Java");

        str1.substring(1);
        System.out.println(str1);
        System.out.print(str1 == str2);
        System.out.print(str1 == str2);
        StringBuilder sb1 = new StringBuilder("Java");
        str1 = sb1. toString();
        str2 = sb1. substring(0);
        System.out.println(str1);
        System.out.println(str2);
        System.out.print(str1 == str2);
        sb1 = new StringBuilder("Java");
        sb1.setLength(3);
        sb1.substring(1);
        System.out.print(sb1);

        sb1 = new StringBuilder ("Java");
        StringBuffer sb2 = new StringBuffer("Java");
        str2 = new String("Java");
        System.out.print(sb1.capacity() == sb2.capacity());
        System.out.print(sb1.hashCode() == sb2.hashCode());
        System.out.print(sb1.hashCode() == str2.hashCode());

        str1 = new String("0123456789");
        str1 = str1. substring (2, 4);
        System.out.print(str1);

        work("Java");
        sb1 = new StringBuilder("Java");
        sb1.setLength(4);
        sb1.append("-8");
        System.out.print(sb1);
        String str3 = str1.replace("a", "-");
        str1 = str1.replace("a", "-");

        System.out.println(str1);
        System.out.println(str3);

        IntStream chars = new StringBuffer(str1).chars();
        System.out.println(chars);
        System.out.println(str1.toCharArray());
        StringBuilder sb = new StringBuilder("1");
        work(sb);
        System.out.print(sb);
    }

    public static void work(String s) {
        System.out.println("String" + s);
    }

    public static void work(StringBuilder sb) {
        System.out.println("StringBuilder " + sb);
    }
}
