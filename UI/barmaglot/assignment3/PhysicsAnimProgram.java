package com.shpp.p2p.cs.ppolyak.assignment3;
import java.awt.*;
import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

public class PhysicsAnimProgram extends WindowProgram {
    private static final double BALL_SIZE = 50;
    private static final double PAUSE_TIME = 1000.0 / 48;
    private static final double HORIZONTAL_VELOCITY = 2.0;
    private static final double GRAVITY = 0.425;
    private static final double ELASTICITY = 0.75;

    public void run() {
        GOval ball = makeBall();
        add(ball);
        bounceBall(ball);
    }

    /**
     * Creates a ball that can be bounced, placing it in the upper-left corner
     * of the screen.
     *
     * @return A ball that can be bounced.
     */
    private GOval makeBall() {
        GOval ball = new GOval(0, 0, BALL_SIZE, BALL_SIZE);
        ball.setFilled(true);
        ball.setColor(Color.BLUE);
        return ball;
    }

    private void bounceBall(GOval ball) {
        double dy = 0;
        while (true) {
            ball.move(HORIZONTAL_VELOCITY, dy);
            dy += GRAVITY;
            if (ballBelowFloor(ball) && dy > 0 ) dy *= -ELASTICITY; // 10 * -(0.5) ==> -5
            pause(PAUSE_TIME);
        }
    }


    private boolean ballBelowFloor(GOval ball) {
        return ball.getY() + ball.getHeight() >= getHeight();
    }
}
