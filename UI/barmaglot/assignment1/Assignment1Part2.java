package com.shpp.p2p.cs.ppolyak.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    public void run() throws Exception {
        while (frontIsClear()) {
            gotoNextColumn();
        }
        gotoNextColumn();
    }

    /**
     * Prerequisites: The Karel build the Column  & move four steps
     * Result: The Karel turnLeft, buildColumn and moveBack
     */
    private void gotoNextColumn() throws Exception {
        turnLeft();
        buildColumn();
        moveBack();
    }

    /**
     * Prerequisites: The Karel build the Column
     * Result: The Karel check & goto while frontIsClear, put the Beeper
     * and move step forward;
     */
    private void buildColumn() throws Exception {
        while (frontIsClear()) {
            checkBeeper();
            checkStep();
        }
    }

    /**
     * Prerequisites: The Karel check before put the Beeper
     * Result: The Karel checks if it is forward the Beeper present.
     *         if the Beepers no Present the Karel put the Beeper
     */
    private void checkBeeper() throws Exception {
        if (!beepersPresent()) putBeeper();
    }

    /**
     * Prerequisites: The Karel return on main row & goto next Column
     * Result: The Karel checks if it is forward the Beeper present.
     *       if no beepersPresent the Karel putBeeper & turnRound
     */
    private void moveBack() throws Exception {
        checkBeeper();
        turnAround();
        while (frontIsClear()) {
            gotoNext();
        }
        turnLeft();
        gotoNext();
    }

    /**
     * Prerequisites: The Karel check if frontIsClear to move a step
     * Result: The Karel checks if it is possible to take a step forward
     */
    private void checkStep() throws Exception {
        if (frontIsClear()) move();
    }

    /**
     * Prerequisites: The Karel turnAround
     * Result: The Karel turned twice
     */
    private void turnAround() throws Exception {
        for (int i = 0; i < 2; i++) turnLeft();
    }

    /**
     * Prerequisites: The Karel checks if it is possible to take tour steps forward
     * Result: The Karel taking four steps forward to the next Column
     */
    private void gotoNext() throws Exception {
        for (int i = 0; i < 4; i++) checkStep();
    }
}
