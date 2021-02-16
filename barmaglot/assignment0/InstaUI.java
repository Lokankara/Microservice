package com.ibJarrett.instagramnameeffect;

import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        while (true)
        marqueeText();
    }

    public static void marqueeText() {
        StringBuilder name = new StringBuilder("Jarrett+B.");
        StringBuilder newname = new StringBuilder("----------");
        try {
            for (int i = 0; i < name.length(); i++) {
                newname.setCharAt(i, name.charAt(i));
                Thread.sleep(5000);
                ProcessBuilder p = new ProcessBuilder("curl", "")
                System.out.println(newname);
                try {
                    p.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Thread.sleep(60000);
            newname = new StringBuilder("----------");
            for(int i = name.length(); i-- > 0;) {
                newname.setCharAt(i, name.charAt(i));
                Thread.sleep(5000);
                ProcessBuilder p = new ProcessBuilder("curl", "")
		System.out.println(newname);
                try {
                    p.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}