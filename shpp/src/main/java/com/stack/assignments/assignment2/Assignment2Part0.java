package com.stack.assignments.assignment2;

import java.util.Random;
import java.util.Scanner;
public class Assignment2Part0 {
    static String p="x²"; static String r="x";static String s="";
    static Integer x; static Integer y; static Integer z;
    static int[] arr = {0, 0, 0};
    public static void main(String[] args){

        while (true){
            r="x"; p="x²";s="";
//            gen();
//            for (int l = 0; l < arr.length; l++) {
//                System.out.println(arr[l]);
//            }

            System.out.println("ax²+bx+c=0");

            try{

                System.out.print("Input int a: ");
                Scanner a = new Scanner(System.in);
                arr[0] = a.nextInt();
                System.out.print("Input int b: ");
                Scanner b = new Scanner(System.in);
                arr[1] = b.nextInt();
                System.out.print("Input int c: ");
                Scanner c = new Scanner(System.in);
                arr[2] = c.nextInt();

                di(arr);

            }catch(Exception e){System.out.println("Input integer values");}
            System.out.print("Try again(1|0): ");
            Scanner n = new Scanner(System.in);
            if (n.nextInt() == 0) break;
            else continue;

//            Scanner in = null;
//            try {
//                in = new Scanner(new File("D:/t.txt"));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
            //String s = in.nextLine();

        }}

    private static void di(int[] arr) {

        x= Assignment2Part1.arr[0];y= Assignment2Part1.arr[1];z= Assignment2Part1.arr[2];

        if (x==0) p="";else if (x==-1) p="-"+p;else if (x==1) p=p;else p=x+p;
        if (y==0) r="";else if (y<=-1) r=y+r;else if (y==1) r=r;else r="+"+y+r;
        if (z==0) s="0";else if (z<=-1) s=s+z;else s="+"+z+s;
        System.out.println(p+r+s+"=0");
        float d = y*y - (4*x*z);
        System.out.println("Discriminant " + d);
        if (d<0){ System.out.println("No real root"); }
        if (d==0){ System.out.println("One root: "+ y/2*x*-1); }
        if (d>0){ System.out.println("Two roots: "+ (y*-1+Math.sqrt(d))/2*x + " & " + (y*-1-Math.sqrt(d))/2*x); }
    }

//    private static void gen(){
//    Scanner SC = new Scanner(System.in);
//    int maxRange;
//    System.out.print("Please enter maximum range: ");
//    maxRange=SC.nextInt();
//
//    for(int loop=1; loop<=10; loop++)
//    {
//        Random a = new Random();
//        Random b = new Random();
//        Random c = new Random();
//        //System.out.println(a.nextInt(maxRange)+" "+b.nextInt(maxRange)+" "+c.nextInt(maxRange));
//        arr[0] = a.nextInt(maxRange);
//        arr[1] = b.nextInt(maxRange);
//        arr[2] = c.nextInt(maxRange);
//
//    }}
}
