//package com.shpp.p2p.cs.ppolyak.assignment3;
//import com.shpp.p2p.cs.ppolyak.assignment2.ExtendedGraph;
//
//public class Assignment3Part0 extends ExtendedGraph {
//
//    public void run() {
//
//        int c = 0;
//        double sum = doLoop();
//        println(sum);
//        println(sum/7);
//        pause(1000);
//        boolean fish = true;
//        boolean meat = false;
//        if(!fish && !meat) println("good");
//        if(!(fish || meat)) println("good");
//        f(5);
//        exit();
//    }
//
//    private void f(int n) {
//    }
//
//    private double doLoop() {
//        int c = 0;
//        double sum = 0;
//        while (true) {
//            c++;
//            int a = readInt("How many minutes did you do on day "+c+":");
//            if (a == STOP_NUMBER) return sum;
//            else sum+=a;
//            if (c == 7) return sum;
//        }
//    }
//
//}
