package com.shpp.p2p.cs.ppolyak.assignment2;
import acm.graphics.GOval;
import acm.graphics.GRect;
import java.awt.*;


/**  Dynamic Graphic:
 *   My Task: create the following:
 *   Draw the white rectangle superimposed on four circles.
 *   The Program should be flexible & using CONSTs
 *   with Depends on APPLICATION_WIDTH, APPLICATION_HEIGHT, RADUIS
 *   use getWidth() & getHeight()
 */

/**  Assignment2Part2 extends ExtendedGraph */
public class Assignment2Part2 extends ExtendedGraph {

/**  CONST Vars: RADIUS, Zero_POINT, App_WIDTH, App_HEIGHT*/
    private static final int DIAMETR = 100;
    public static final int OFFSET_ZERO = 0;
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;

    public void run() {

/**  set X and Y coordinate points relative to length & height
 *   set 4 Circles
 *   set 1 Rectangle
 *   Initializations the Figures*/
        double x = getWidth() - DIAMETR;
        double y = getHeight()- DIAMETR;
        GRect rect1 = new GRect(DIAMETR / 2, DIAMETR / 2, x, y);
        GOval oval1 = new GOval(OFFSET_ZERO, OFFSET_ZERO, DIAMETR, DIAMETR);
        GOval oval2 = new GOval( x, OFFSET_ZERO, DIAMETR, DIAMETR);
        GOval oval3 = new GOval(OFFSET_ZERO, y, DIAMETR, DIAMETR);
        GOval oval4 = new GOval( x, y, DIAMETR, DIAMETR);
        setOval(oval4);
        setOval(oval3);
        setOval(oval2);
        setOval(oval1);
        setRect(rect1, Color.WHITE);
    }
}