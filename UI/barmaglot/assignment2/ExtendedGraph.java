package com.shpp.p2p.cs.ppolyak.assignment2;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;

public class ExtendedGraph extends WindowProgram {
    /**Color CONST */
    public static final Color CARDINAL_RED = new Color(145, 0, 0);
    public static final Color CARDINAL_YELLOW = new Color(0, 190, 0);
    public static final Color CARDINAL_GREEN = new Color(50,140,50);
    /**  The Circle Figure Constructor
     *   set X and Y coordinate points & Color Figure
     *   draw the figure
     */
    void setOval(GOval figure) {
        figure.setFilled(true);
        figure.setColor(Color.BLACK);
        add(figure);
    }
    /**  The Rectangle Figure Constructor
     *   set X and Y - coordinate points & Color Figure
     *   draw the figure
     */
    void setRect(GRect figure, Color color) {
        figure.setColor(color);
        figure.setFilled(true);
        add(figure);
    }
}
