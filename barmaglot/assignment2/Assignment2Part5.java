package com.shpp.p2p.cs.barmaglot.assignment2;
import java.awt.*;
import javax.swing.JFrame;

public class Assignment2Part5 extends Canvas {
    final int YELLOW = 0xFFFF00;
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;
    private static final double BOX_SIZE = 40;
    private static final double BOX_SPACING = 10;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Canvas");
        Canvas canvas = new Assignment2Part5();
        canvas.setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
        frame.add(canvas);frame.pack();frame.setVisible(true); }

    public void paint(Graphics g) {
        g.setColor(Color.white);g.fillRect(0,0,400,400);
        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, 100, 100);
        g.fillOval(300, 300, 100, 100);
        g.fillOval(0, 300, 100, 100);
        g.fillOval(300, 0, 100, 100);
        g.setColor(Color.white);g.fillRect(50,50,300,300);
        g.setColor(Color.blue);
        for(int i=1;i<=NUM_ROWS; i++){
            for(int j=1;j<=NUM_COLS; j++){
            g.fillRect(i*(int)(BOX_SIZE+BOX_SPACING),j*(int)(BOX_SIZE+BOX_SPACING),(int)(BOX_SIZE),(int)BOX_SIZE);}}

        g.setColor(Color.black);
        //for(int i=1;i<7; i++){g.fillOval(i*50, 175, 50, 50);}





    }
//    }
}
