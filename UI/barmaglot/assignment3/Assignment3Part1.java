package com.shpp.p2p.cs.ppolyak.assignment3;
import com.shpp.cs.a.console.TextProgram;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Assignment3Part1 extends TextProgram {
    //Depends
    private static final int BLOOD = 40;
    private static final int CARDIO = 30;
    private static final int BLOOD_TIMES = 3;
    private static final int CARDIO_TIMES = 5;
    private static final int STOP_NUMBER = 0;
    Integer x; static Integer y; static Integer z;

    public static String[] user = new String[] {"0","15","60","15","60","15","60","15"};
    static String[] data = new String[8];
    static int b = 0;
    static int c = 0;
    public void run(){
        //user input

        testCase_1(user);
        bloodCardio();
        user = new String[] {"0","40","30","30","30","10","40","30"};
        b=0;c=0;
        testCase_1(user);
        bloodCardio();
        }

    private void bloodCardio() {
        for (int j=1 ;j<8;j++) {
            if (Integer.parseInt(data[j])>=CARDIO){c++;
            if (Integer.parseInt(data[j])>=BLOOD)b++;}
            System.out.print(data[j]+" ");}
        result();

    }

    private void testCase_1(String[] user) {
        for (int i=1;i<8;i++) {
            System.setIn(new ByteArrayInputStream(Assignment3Part1.user[i].getBytes()));
            inputValues(user[i],i);
        }
    }

    private void result() {println("BLOOD_TIMES: "+b+" CARDIO_TIMES: "+c);
        println();
        if (c-CARDIO_TIMES>=0) println("Cardiovacular health: Great job! You've done enough exercise to keep a low blood pressure.");
        else println("Cardiovacular health: You needed to train hard for at least "+(CARDIO_TIMES-c)+" more day(s) a week!");
        if (b-BLOOD_TIMES>=0) println("Blood pressure: Great job! You've done enough exercise to keep a low blood pressure.");
        else println("Blood pressure: You needed to train hard for at least "+(BLOOD_TIMES-b)+" more day(s) a week!");
    }

    private static void inputValues(String user,int i){

            System.out.print("How many minutes did you do on day "+i+": ");
            Scanner scanner = new Scanner(System.in);
            String o = scanner.next();
            System.setIn(new ByteArrayInputStream(user.getBytes(StandardCharsets.UTF_8)));
            System.out.println(o);
            data[i]= o;
            scanner.close();
}}