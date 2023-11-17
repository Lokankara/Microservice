package com.shpp.p2p.cs.ppolyak.assignment3;

import java.awt.*;

import acm.graphics.GFillable;
import acm.graphics.GLine;
import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

/**
 * Chain of Responsibility:
 * TASK: Use GOval and draw the fairy Caterpillar.
 * The ovals should overlap in the correct order, width screen depend on the Caterpillar LENGTH
 */
public class SnowMan extends WindowProgram {
    //Depends
    private static final int LENGTH = 2;
    private static final double OFFSET_X = 0;
    private static final double OFFSET_Y = 0;
    public static final int APPLICATION_WIDTH = (int) 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Odd above the Mediterranean & Even below the Mediterranean
     */
    public void run() {
//      wrap();
        int R = 50;
        int D = R * 2;
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        GOval c2 = createCircle(Color.YELLOW, x-R/1.5, y, R/1.5);
        add(c2);
        GOval c1 = createCircle(Color.RED, x-R/2, y-R*1.5/2-R/4, R/2);
        double x1 = c1.getBounds().getX();
        double y1 = c1.getBounds().getY();
        print(c1.getBounds());
        add(c1);

        print(c2.getBounds());
        add(createCircle(Color.GREEN, x-R, y+R*1.5/2+R/4+R/2-10, R));
        add(new GLine(x, y-R+R/1.5,x, y+R*2.1));
        pause(3000);
        exit();
    }

    /**
     * The Dynamic Constructor which draw each the piece of caterpillar
     *
     * @return
     **/
    private GOval createCircle(Color color, double x, double y, double RADIUS) {

        GOval figure = new GOval(OFFSET_X+x, y, RADIUS, RADIUS);
        GOval res = new GOval(OFFSET_X + x, y, RADIUS * 2, RADIUS * 2);
        fillOval(res, color);
        return res;

    }

    private void fillOval(GFillable obj, Color color) {
        obj.setFillColor(color);
        obj.setFilled(true);

    }
}

//    private void wrap() {
//        for (int i = 0; i < LENGTH; i++) {
//            if (i % 2 == 0) draw(i * DISTANCE, OFFSET_Y, CARDINAL_YELLOW);
//            else draw(i * DISTANCE, OFFSET_X, CARDINAL_GREEN);
//        }
//    }
