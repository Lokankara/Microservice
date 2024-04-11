package com.stack.automation.strings;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class Main {
    public static void work(int i) {
        log.info(String.valueOf(i));
        i = i + 1;
        log.info(String.valueOf(i));
    }

    public static void work(StringBuilder sb) {
        log.info(sb.toString());
        sb.append("2");
        log.info(sb.toString());
    }

    public static void work(String s) {
        log.info(s);
        s = s + "2";
        log.info(s);
    }

    public static void eq1(){
        String str1 = getString();
        String str2 = "Java";
        log.info(String.valueOf(str1 == str2));
    }

    public static void eq2(){
        String str1 = "Java";
        String str2 = getString();
        log.info(String.valueOf(str1 == str2));
    }

    public static void eq5(){
        String str1 = "Java";
        String str2 = "Java";
        log.info(String.valueOf(str1 == str2));
    }

    public static void eq7(){
        StringBuilder str1 = getBuilder();
        String str2 = getString();
        log.info(String.valueOf(str1.toString() == str2));
    }

    public static void eq8(){
        StringBuilder sb1 = getBuilder();
        String str1 = sb1.toString();
        String str2 = sb1.substring(0);
        log.info(str1);
        log.info(str2);
        log.info(String.valueOf(str1 == str2));
    }

    public static void eq9(){
        StringBuilder str1 = getBuilder();
        str1.setLength(3);
        log.info(String.valueOf(str1));
    }

    public static void eq10(){
        StringBuilder sb1 = getBuilder();
        sb1.substring(1);
        log.info(String.valueOf(sb1));
    }

    public static void eq11(){
        StringBuilder str1 = getBuilder();
        StringBuilder str2 = getBuilder();
        log.info(String.valueOf(str1.hashCode() == str2.hashCode()));
    }

    public static void eq12(){
        String str1 = new String( "0123456789");
        str1 = str1.substring(2, 4);
        log.info(str1);
    }

    public static void eq13(){
        StringBuilder sb1 = getBuilder();
        sb1.setLength(4);
        sb1.append("-8");
        log.info(String.valueOf(sb1));
    }

    public static void eq14(){
        StringBuilder sb1 = getBuilder();
        sb1.insert(5, "-8");
        log.info(String.valueOf(sb1));
    }

    public static void eq15(){
        String str1 = "Java";
        str1 = str1.replace("a", "-");
        log.info(str1);

        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");
        Collections.sort(list);
        log.info(list.toString());
        Set<String> set = new HashSet<>();
        set = Collections.synchronizedSet(set);
        set.add(null);
        log.info(set.toString());
    }

    private static String getString() {
        return new String("Java");
    }

    private static StringBuilder getBuilder() {
        return new StringBuilder( "Java");
    }
}
