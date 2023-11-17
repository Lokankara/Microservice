package com.shpp.p2p.cs.ppolyak.assignment2;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import java.awt.Color;

/** Task: Draw the Flag + Label*/
public class Assignment2Part4 extends ExtendedGraph {
    /** Constants controlling the relative positions & all Color;
     * Horizontally & Vertically Split;
     * Two & three colors flags
     * */
    private static final Color CARDINAL_WHITE = new Color(255, 255, 255);
    private static final Color CARDINAL_RED = new Color(196, 30, 58);
    private static final Color CARDINAL_BLUE = new Color(0, 0, 255);
    private static final Color CARDINAL_GREEN = new Color(0, 255, 0);
    private static final Color CARDINAL_YELLOW = new Color(254,255,0);
    public static int APPLICATION_WIDTH = 500;
    public static int APPLICATION_HEIGHT = 400;
    public static int WIDTH = 300;
    public static int HEIGHT = 200;
    boolean isVertical;
    public int count;
    public double OFFSET_X = APPLICATION_WIDTH/2 - WIDTH/2;
    public double OFFSET_Y = APPLICATION_HEIGHT/2 - HEIGHT/2-10;
    /** Runner: Draw object with values: splitter, colors & name a country*/
    public void run() {
        print(OFFSET_X);
        draw(3, Color.BLACK, CARDINAL_YELLOW, CARDINAL_RED,"Belgium",true);
        draw(3, CARDINAL_GREEN, CARDINAL_WHITE,CARDINAL_GREEN,"Nigeria",true);
        draw(2, CARDINAL_RED, Color.ORANGE ,CARDINAL_WHITE,"Rome",true);
        draw(3, CARDINAL_BLUE, CARDINAL_YELLOW,CARDINAL_RED,"Romania",true);
        draw(3, CARDINAL_RED, CARDINAL_WHITE,CARDINAL_RED,"Peru ",true);
        draw(3, CARDINAL_GREEN, CARDINAL_WHITE,Color.ORANGE,"Ireland",true);
        draw(3, CARDINAL_GREEN, CARDINAL_WHITE,CARDINAL_RED,"Italy",true);
        draw(2, CARDINAL_RED, Color.WHITE, CARDINAL_BLUE, "Indonesia",false);
        draw(3, CARDINAL_WHITE, CARDINAL_BLUE,CARDINAL_RED,"Russia",false);
        draw(3, CARDINAL_RED, CARDINAL_WHITE,CARDINAL_BLUE,"Netherlands ",false);
        draw(2, Color.WHITE, CARDINAL_RED, CARDINAL_BLUE, "Poland",false);
        draw(3, CARDINAL_RED, CARDINAL_WHITE,CARDINAL_RED,"Austria ",false);
        draw(3, Color.BLACK, CARDINAL_RED,CARDINAL_YELLOW,"Germany",false);
        draw(3, CARDINAL_RED, CARDINAL_WHITE,CARDINAL_GREEN,"Netherlands ",false);
        draw(2, CARDINAL_BLUE, CARDINAL_YELLOW, CARDINAL_RED,"Ukraine",false);
    }
    /** The Constructor:
     * Check two || three color
     * Check is Vertically || is Horizontally
     * Init The Flag setRect()
     * Add The Label() with name a county
     */
    private void draw(int count,Color c1,Color c2,Color c3, String name, boolean isVertical) {
        //background
        GRect wrap = new GRect(OFFSET_X, OFFSET_Y+2, WIDTH+2, HEIGHT+2);
        setRect(wrap, Color.GRAY);

        if (isVertical) {
            GRect first = new GRect(OFFSET_X, OFFSET_Y, WIDTH / count, HEIGHT);
            GRect second = new GRect(OFFSET_X + WIDTH / count, OFFSET_Y, WIDTH / count, HEIGHT);
            GRect third = new GRect(OFFSET_X + WIDTH / count * 2, OFFSET_Y, WIDTH / count, HEIGHT);
            if (count==3)setRect(third, c3);
            setRect(second, c2);
            setRect(first, c1);
            setLabel("The Flag of "+ name);
        } else {
            GRect first = new GRect(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
            GRect second = new GRect(OFFSET_X, OFFSET_Y+HEIGHT/count,  WIDTH, HEIGHT/count);
            GRect third = new GRect(OFFSET_X, OFFSET_Y,  WIDTH, HEIGHT/count);
            if (count==3)setRect(third, c3);
            setRect(first, c1);
            setRect(second, c2);
            setLabel("The Flag of "+ name);
        }
        pause(1000); //delay
    }
//set Label bottom {name}
    public void setLabel(String name) {
   GRect back = new GRect(APPLICATION_WIDTH-200, APPLICATION_HEIGHT-50, 200, 30);
        setRect(back, Color.LIGHT_GRAY);
        GLabel label = new GLabel(name, APPLICATION_WIDTH-200, APPLICATION_HEIGHT-30);
        label.setFont("Verdana-16");
        label.setColor(Color.BLACK);
        add(label);
    }
}
