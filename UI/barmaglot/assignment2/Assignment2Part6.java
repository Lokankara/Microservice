package com.shpp.p2p.cs.ppolyak.assignment2;
import java.awt.*;
import acm.graphics.GOval;

/**Chain of Responsibility:
 * TASK: Use GOval and draw the fairy Caterpillar.
 * The ovals should overlap in the correct order, width screen depend on the Caterpillar LENGTH
 */
public class Assignment2Part6 extends ExtendedGraph {
//Depends
    private static final int LENGTH = 9;
    private static final double OFFSET_X = 20;
    private static final double OFFSET_Y = 0;
    private static final double DIAMETR = 10;
    private static final double DISTANCE = DIAMETR * 0.66 ;
    public static final int APPLICATION_HEIGHT = (int) (DIAMETR *2.5-2);
    public static final int APPLICATION_WIDTH = (int)Math.round(LENGTH*DISTANCE+ DIAMETR * 0.66/2+2);

    /** Odd above the Median & Even below the Median*/
    public void run() {
        for (int i = 0; i < LENGTH; i++) {
            if (i % 2 == 0) draw(i * DISTANCE, OFFSET_Y, CARDINAL_YELLOW);
            else draw(i * DISTANCE, OFFSET_X, CARDINAL_GREEN);
        }
    }
    /**The Dynamic Constructor which draw each the piece of caterpillar **/
    private void draw(double x, double y, Color color) {
        GOval figure = new GOval(x, y, DIAMETR, DIAMETR);
        figure.setColor(CARDINAL_RED);
        figure.setFilled(true);
        figure.setFillColor(color);
        add(figure);
    }
}
