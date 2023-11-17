package com.shpp.p2p.cs.ppolyak.assignment3;
import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;

public class PrimeAnimationGenerator extends WindowProgram {
    private static final int STOP_NUMBER = 0;
    private static final int N = 10;
    private static final double PAUSE_TIME = 1000.0 / 48;
    private static final double BALL_SIZE = 50;
    private static final double GRAVITY = 0.425;
    private static final double ELASTICITY = 0.85;
    private static final double HORIZONTAL_VELOCITY = 1.0;

    public void run() {
        GOval ball = makeBall();
        add(ball);
        bounceBall(ball);

    }

    private void printing(int i) {
        println(i);
    }
    private void printing(String i) {
        println(i);
    }
    private GOval makeBall() {
        GOval ball = new GOval(0, 0, BALL_SIZE, BALL_SIZE);
        ball.setFilled(true);
        ball.setColor(Color.RED);
        return ball;
    }

    private GOval bounceBall(GOval ball) {
        double dy = 0;

        while (true) {
            ball.move(HORIZONTAL_VELOCITY, dy);
            if (ball.getX() > 1000) println(ball.getX());
            dy += GRAVITY;

            if (ballBelowFloor(ball) && dy > 0) dy *= -ELASTICITY;

            pause(PAUSE_TIME);


        }
    }

    private boolean ballBelowWall(GOval ball) {
        return ball.getX() + ball.getWidth() >= getWidth();}


    private boolean ballBelowFloor(GOval ball) {
        return ball.getY() + ball.getHeight() >= getHeight();}
}


//        obj.setLocation(x,y);
//        obj.move(dx,dy)
//        obj.setColor(color)
//        while ((animation, update GUI, pause))
//            c = readInt("enter some number: ");

//genPrime();
//        GOval o = new GOval(0,0,100,100);
//        add(o);
//        while (true){
//            o.move(5,5);
//            pause(100);
//        }

//
//    private void genPrime() {
//        for (int i=0; i<N; i++) {
//        RandomGenerator x1 = RandomGenerator.getInstance();
//        int c = x1.nextInt(50);
//        if (!(c >= 10 && c<100)) continue;
//        boolean isSimple = checkIfSimple(c);
//        if (isSimple) println(c + " ohh.. not simple ");
//        else println(c + " very simple");
//    }
//    }
//
//    private boolean checkIfSimple(double number) {
//        if (number <= 2) return true;
//        for (int i = 2; i< number; i++) if (number % i == 0) return false;
//        return true;
//    }
