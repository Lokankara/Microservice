package com.stack.assignments.assignment1;

public class Assignment1Part4 extends KarelTheRobot {
    public void run() throws Exception {
        putFirstRow();
        buildColumn();
    }

    /**
     * Prerequisites: The Karel put First Row
     * Result: The Karel gotoStep & putBeeper until front Is not Blocked
     */
    private void putFirstRow() throws Exception {
        putBeeper();
        checkOddOrEven();
        turnLeft();
    }

    /**
     * Prerequisites: The Karel put the Beepers on the Column
     * Result: if tht beeper Present The Karel  pickBeeper & gotoStep
     */
    private void buildColumn() throws Exception {
        while (frontIsClear()) {
            checkOddOrEven();
            gotoStart();
            turnRight();
            gotoNextColumn();
        }
    }

    /**
     * Prerequisites: The Karel check the Column odd or even
     * Result: The Karel checks if the Beeper no Present & put the Beeper
     */
    private void checkOddOrEven() throws Exception {
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                checkStep();
                putBeeper();
            } else {
                checkStep();
            }
        }
    }

    /**
     * Prerequisites: The Karel moving to the next in the Column
     * Result: The Karel checks if front Is Clear & move
     */
    private void gotoNextColumn() throws Exception {
        if (frontIsClear()) {
            move();
            turnRight();
        }
    }

    /**
     * Prerequisites: The Karel move to the start
     * Result: while frontIsClear The Karel checkStep & return
     */
    private void gotoStart() throws Exception {
        turnAround();
        while (frontIsClear()) checkStep();
    }

    /**
     * Prerequisites: The Karel turnRight
     * Result: The Karel turnedLeft three times
     */
    public void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    /**
     * Prerequisites: The Karel turnAround
     * Result: The Karel turned twice
     */
    public void turnAround() throws Exception {
        for (int i = 0; i < 2; i++) {
            turnLeft();
        }
    }

    /**
     * Prerequisites: The Karel moving until frontIsClear
     * Result: The Karel checks if it is possible to take steps forward & moving
     */
    public void checkStep() throws Exception {
        if (frontIsClear()) {
            move();
        }
    }
}
