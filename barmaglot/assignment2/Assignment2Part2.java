//package com.shpp.p2p.cs.barmaglot.assignment2;
//import java.awt.*;
//import javax.swing.JFrame;
//
//public class Assignment2Part2 extends Canvas {
//    public static final int APPLICATION_WIDTH = 400;
//    public static final int APPLICATION_HEIGHT = 400;
//
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Canvas");
//        Canvas canvas = new Assignment2Part2();
//        canvas.setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
//        frame.add(canvas);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public void paint(Graphics g) {
//        g.setColor(Color.white);
//        g.fillRect(0,0,400,400);
//        g.setColor(Color.red);
//        g.fillOval(0, 0, 100, 100);
//        g.fillOval(300, 300, 100, 100);
//        g.fillOval(0, 300, 100, 100);
//        g.fillOval(300, 0, 100, 100);
//        g.setColor(Color.white);
//        g.fillRect(50,50,300,300);
//    }
//}
