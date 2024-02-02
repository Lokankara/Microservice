package com.stack.assignments.assignment2;
import acm.graphics.GOval;

/**  Dynamic Graphic:
 *   Method drawPawPrint(double x, double y)
 *
*/
public class Assignment2Part3 extends ExtendedGraph {
        /* Constants controlling the relative positions of the
         * three toes to the upper-left corner of the pawPrint.
         *
         * (Yes, I know that actual pawPrints have four toes.
         * Just pretend it's a cartoon animal. ^_^)
         */
        private static final double FIRST_TOE_OFFSET_X = 0;
        private static final double FIRST_TOE_OFFSET_Y = 20;
        private static final double SECOND_TOE_OFFSET_X = 30;
        private static final double SECOND_TOE_OFFSET_Y = 0;
        private static final double THIRD_TOE_OFFSET_X = 60;
        private static final double THIRD_TOE_OFFSET_Y = 20;

        /* The position of the heel relative to the upper-left
         * corner of the pawPrint.
         */
        private static final double HEEL_OFFSET_X = 20;
        private static final double HEEL_OFFSET_Y = 40;

        /* Each toe is an oval with this width and height. */
        private static final double TOE_WIDTH = 20;
        private static final double TOE_HEIGHT = 30;

        /* The heel is an oval with this width and height. */
        private static final double HEEL_WIDTH = 40;
        private static final double HEEL_HEIGHT = 60;

        /* The default width and height of the window. These constants will tell Java to
         * create a window whose size is *approximately* given by these dimensions. You should
         * not directly use these constants in your program; instead, use getWidth() and
         * getHeight(), which return the *exact* width and height of the window.
         */
        public static final int APPLICATION_WIDTH = 270;
        public static final int APPLICATION_HEIGHT = 220;

        public void run() {
            drawPawPrint(20, 20);
            drawPawPrint(180, 70);
//            drawPawPrint(20, 200);
//            drawPawPrint(180, 250);
        }

        /**
         * Draws a pawPrint. The parameters should specify the upper-left corner of the
         * bounding box containing that pawPrint.
         *
         * @param x The x coordinate of the upper-left corner of the bounding box for the pawPrint.
         * @param y The y coordinate of the upper-left corner of the bounding box for the pawPrint.
         */
        private void drawPawPrint(double x, double y) {
        //Init the each Figure with Depends of WIDTH & OFFSET on X & Y
            GOval toe1 = new GOval(x+FIRST_TOE_OFFSET_X, y+FIRST_TOE_OFFSET_Y,  TOE_WIDTH, TOE_HEIGHT);
            GOval toe2 = new GOval(x+SECOND_TOE_OFFSET_X, y+SECOND_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);
            GOval toe3 = new GOval(x+THIRD_TOE_OFFSET_X, y+THIRD_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);
            GOval heel = new GOval(x+HEEL_OFFSET_X, y+HEEL_OFFSET_Y, HEEL_WIDTH, HEEL_HEIGHT);
        //Call the Figure Method
            setOval(heel);
            setOval(toe1);
            setOval(toe2);
            setOval(toe3);
        }
}
