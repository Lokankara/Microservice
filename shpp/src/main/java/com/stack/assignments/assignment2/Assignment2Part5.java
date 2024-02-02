package com.stack.assignments.assignment2;
import acm.graphics.GRect;
import java.awt.*;
public class Assignment2Part5 extends ExtendedGraph {
    /** CONST*/
    /**APPLICATION_WIDTH & APPLICATION_HEIGHT depended on BOX_SIZE, NUM_ROWS & NUM_COLS */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;
    private static final double BOX_SIZE = 30;
    private static final double BOX_SPACING = 2;
    public static final int APPLICATION_WIDTH = (int) (NUM_COLS*(BOX_SIZE+BOX_SPACING)+2);
    public static final int APPLICATION_HEIGHT = (int) ((NUM_ROWS)*(BOX_SIZE+BOX_SPACING)+(BOX_SIZE+BOX_SPACING));

    public void run(){
        drawChessBoard(NUM_ROWS,NUM_COLS);
        println(APPLICATION_WIDTH);
        println(APPLICATION_HEIGHT);
    }

    /**The method which draw ChessBoardRows with Sub method & The Constructor */
    private void drawChessBoard(int rows, int cols) {
        boolean black = true;
        for(int i=0;i<rows; i++) {
            drawChessBoardRow(i, cols, black=!black);
            println();
        }
    }
    /**The method which call The Constructor each square of the ChessBoard & drawChessBoardRow */
    private void drawChessBoardRow(int rowNum, int cols, boolean black) {
        for(int i=0;i<cols; i++) {
            print((rowNum+i)%2);
            drawChessBoardItem(rowNum, i, black=!black);
        }
    }
    /**The Dynamic Constructor which draw each square **/
    private void drawChessBoardItem(int rowNum, int colNum, boolean black) {
        GRect r = new GRect(colNum*(BOX_SIZE+BOX_SPACING)+BOX_SPACING/2, rowNum*(BOX_SIZE+BOX_SPACING)+BOX_SPACING/2, BOX_SIZE,BOX_SIZE);
        r.setFilled(true);
        r.setFillColor(black ? Color.BLACK: Color.BLACK);
        r.setColor(Color.LIGHT_GRAY);
        add(r);
    }
}
