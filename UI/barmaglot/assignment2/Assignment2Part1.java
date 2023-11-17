package com.shpp.p2p.cs.ppolyak.assignment2;
import java.util.Scanner;
/**Solve the square equation formula using the discriminant*/
public class Assignment2Part1 {
//decorators a,b,c
    static String p="x²"; static String r="x";static String s="";
//values a,b,c
    static Integer x; static Integer y; static Integer z;
    static int[] arr = {0, 0, 0};
    public static void main(String[] args){
        while (true){
            r="x"; p="x²";s="";
            System.out.println("ax²+bx+c=0");
/**
 * Prerequisites: catch the input value errors & try again
 * Result: catch if the user input invalid values (not int)
 */
        try{
            inputValues(arr);
            if (arr[0]==0) {System.out.println("Divide by zero");inputValues(arr);}
            Discriminant(arr);
        } catch(Exception e) {System.out.println("Input integer values");}

/**exit: check repeat or leave (Yes or No)*/
            System.out.print("Try again (1|0): ");
            Scanner n = new Scanner(System.in);
            if (n.nextInt() == 0) break;
            else continue;
 }}

/**
* Prerequisites: append user`s values on Array
* Result: if the user input invalid values (not int) => exit()
 * else put a,b,c in the Array
*/
private static void inputValues(int[] arr){
    System.out.print("Please enter int a: ");
    Scanner a = new Scanner(System.in);
    arr[0] = a.nextInt();
    System.out.print("Please enter int b: ");
    Scanner b = new Scanner(System.in);
    arr[1] = b.nextInt();
    System.out.print("Please enter int c: ");
    Scanner c = new Scanner(System.in);
    arr[2] = c.nextInt();}

    /** Task: Write a console program that will accept 3 numbers on the input of the double (a, b, c) type,
     * and type answers of a square root.
     *
     * Prerequisites: print user`s method with right signs
     * & solves the square equation formula using the discriminant
     * Result: according to the formula if discriminant < 0 - there is no root
     * discriminant = 0 - there is one root
     * discriminant > 0 - there are two roots
     */
private static void Discriminant(int[] arr) {
    x= Assignment2Part1.arr[0];
    y= Assignment2Part1.arr[1];
    z= Assignment2Part1.arr[2];
    signPositiveOrNegative(arr);
        System.out.println("\n"+p+r+s+"=0\n");
    double d = y*y - (4*x*z);
        System.out.println("Discriminant " + d);
    if (d<0){ System.out.println("There is no root"); }
    if (d==0){ System.out.println("There is one root: "+ y/2*x*-1); }
    if (d>0){ System.out.println("There are two roots: "+ (y*-1+Math.sqrt(d))/2*x + " & " + (y*-1-Math.sqrt(d))/2*x);}}

    /**
     * Prerequisites: check sign + or - and change opposite sign
     * print user`s formula with right sign above a, b & c
     * Result: if a=0 is x^2 || x - hidden, if a=-1 is "1" - hidden
     */
    private static void signPositiveOrNegative(int[] arr){
        if (x==0) p=""; else if (x==-1) p="-"+p; else if (x==1) p=p; else p=x+p;
        if (y==0) r=""; else if (y<=-1) r=y+r; else if (y==1) r="+"+r; else r="+"+y+r;
        if (z==0) s=""; else if (z<=-1) s=s+z; else s="+"+z+s; }
}