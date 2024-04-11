package com.stack.automation.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPool {

    String join() {
        char[] chA = {'A', 'B', 'C', 'D', 'E', 'F', 'H'};
        String strThird = new String(chA);
        String strFourth = new String(chA, 2, 4);
        return String.format("%s%n%s%n%s%n",
                             strThird,
                             strFourth,
                             Arrays.toString(chA));
    }

    String operate() {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        System.out.println(s1 + "==" + s2 + " : " + (s1 == s2));
        System.out.println(s1 + "==" + s3 + " : " + (s1 == s3));
        System.out.println(s1 + " equals " + s2 + " : " + s1.equals(s2));
        System.out.println(s1 + " equals " + s3 + " : " + s1.equals(s3));
        String string = "\t I like JAVA\t KAVA\nLanguage\t \n\n\r";
        int ava = string.indexOf("ava");
        char charAt = string.charAt(8);
        System.out.println(charAt);
        System.out.println(ava);
        ava = -1;
        while ((ava = string.indexOf("ava", ava + 1)) >= 0) {
            System.out.println(ava);
        }
        String substring = string.substring(13);
        String upperCase = substring.toUpperCase();
        String range = substring.substring(8, 13);
        boolean iLike = string.startsWith("I like");
        boolean like = string.startsWith("like");
        boolean lang = string.startsWith("lang", 8);
        String trim = string.trim();
        return String.format(
                "%s%n%s%n%s%n%s%n%s%n%s%n",
                upperCase, range, iLike, like, lang, trim);
    }

    public List<String> replace() {
        List<String> result = new ArrayList<>();
        String string = "abracadabra abba";
        string = string.replace("a", "--");
        result.add(string);
        string = string.replace("a\\B", "--");
        result.add(string);
        string = string.replaceAll("a\\B", "--");
        result.add(string);
        string = string.replaceFirst("a", "--");
        result.add(string);
        string = string.replaceFirst("b", "--");
        result.add(string);
        result.add(permitChmod("446"));
        return result;
    }

    public String permitChmod(String chmod) {
        Map<Character, String> permissionMap = new HashMap<>();
        permissionMap.put('0', "---");
        permissionMap.put('1', "--x");
        permissionMap.put('2', "-w-");
        permissionMap.put('3', "-wx");
        permissionMap.put('4', "r--");
        permissionMap.put('5', "r-x");
        permissionMap.put('6', "rw-");
        permissionMap.put('7', "rwx");

        StringBuilder permission = new StringBuilder();

        for (char c : chmod.toCharArray()) {
            permission.append(permissionMap.getOrDefault(c, "Invalid"));
        }

        return permission.toString();
    }

    public String replaceChmod(String chmod) {
        chmod = chmod.replace("0", "---");
        chmod = chmod.replace("1", "--x");
        chmod = chmod.replace("2", "-w-");
        chmod = chmod.replace("3", "-wx");
        chmod = chmod.replace("4", "r--");
        chmod = chmod.replace("5", "r-x");
        chmod = chmod.replace("6", "rw-");
        chmod = chmod.replace("7", "rwx");
        return chmod;
    }

    public String work() {
        StringBuilder sb = new StringBuilder();
        int i;
        char[] s = {'J', 'a', 'v', 'a'};
        String str = new String(s);
        sb.append(str);
        if (!str.isEmpty()) {
            i = str.length();
            sb.append(i);
            str = str.toUpperCase();
            sb.append(str);
            String num = String.valueOf(8);
            sb.append(num);
            num = str.concat("-" + num);
            sb.append(num);
            char ch = str.charAt(2);
            sb.append(ch);
            i = str.lastIndexOf('A');
            sb.append(i);
            num = num.replace("8", "SE");
            sb.append(num);
            String lowerCase = str.substring(0, 4).toLowerCase();
            sb.append(lowerCase);
            str = num + "-8";         // str = "JAVA-SE-8"
            sb.append(str);
            String[] arr = str.split("-|\\.|,| +");
            sb.append(Arrays.toString(arr));
            for (String w : arr) {
                sb.append(w);
            }
        }
        return sb.toString();
    }

    String format(){
        final double PI = 3.1415926;
        String format = "%.2f";
        String s = String.format(format, PI);
        return String.format("%s%s%s", s, format, PI);
    }
}
