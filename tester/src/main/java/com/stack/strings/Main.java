package com.stack.strings;

import com.stack.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void work(int i) {
        System.out.print(i);
        i = i + 1;
        System.out.print( i);
    }

    public static void work(StringBuilder sb) {
        System.out.print(sb);
        sb.append("2");
        System.out.print(sb);
    }

    public static void work(String s) {
        System.out.print(s);
        s = s + "2";
        System.out.print(s);
    }

    public static void eq1(){
        String str1 = new String("Java");
        String str2 = "Java";
        System.out.print(str1 == str2);
    }

    public static void eq2(){
        String str1 = "Java";
        String str2 = new String("Java");
        System.out.print(str1 == str2);
    }

    public static void eq3(){
        String str1 = "Java";
        String str2 = "Java";
        System.out.print(str1 == str2);
    }

    public static void eq4(){
        StringBuilder str1 = new StringBuilder( "Java");
        String str2 = new String("Java");
        System.out.print(str1.toString() == str2);
    }

    public static void eq5(){
        StringBuilder sb1 = new StringBuilder("Java");
        String str1 = sb1.toString();
        String str2 = sb1.substring(0);
        System.out.println(str1);
        System.out.println(str2);
        System.out.print(str1 == str2);
    }

    public static void eq9(){
        StringBuilder str1 = new StringBuilder( "Java");
        str1.setLength(3);
        System.out.print(str1);
    }

    public static void eq10(){
        StringBuilder sb1 = new StringBuilder( "Java");
        sb1.substring(1);
        System.out.print(sb1);
    }

    public static void eq11(){
        StringBuilder str1 = new StringBuilder( "Java");
        StringBuilder str2 = new StringBuilder( "Java");
        System.out.print(str1.hashCode() == str2.hashCode());
    }

    public static void eq12(){
        String str1 = new String( "0123456789");
        str1 = str1.substring(2, 4);
        System.out.print(str1);
    }

    public static void eq13(){
        StringBuilder sb1 = new StringBuilder( "Java");
        sb1.setLength(4);
        sb1.append("-8");
        System.out.print(sb1);
    }

    public static void eq14(){
        StringBuilder sb1 = new StringBuilder( "Java");
        sb1.insert(5, "-8");
        System.out.print(sb1);
    }

    public static void eq15(){
        String str1 = "Java";
        str1 = str1.replace("a", "-");
        System.out.print(str1);

        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");
        Collections.sort(list);
        System.out.println(list);
        Set<String> set = new HashSet<>();
        set = Collections.synchronizedSet(set);
        set.add(null);
        System.out.println(set);

        Queue<String> queue = new LinkedList<>();
        Comparator<User> NameComparator = new Comparator<User>() {
            @Override
            public int compare(
                    User o1,
                    User o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
    }

    public static void main(String[] args) {
        eq15();
//        String s = "1";
//        work(s);
//        System.out.print(s);
//        StringBuilder sb = new StringBuilder("1");
//        work(sb);
//        System.out.print(sb);
//        int i = 1;
//        work(i);
//        System.out.print(i);
    }
}
