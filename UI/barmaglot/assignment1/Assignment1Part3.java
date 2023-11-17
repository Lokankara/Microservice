package com.shpp.p2p.cs.ppolyak.assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {
    public void run() throws Exception {
        if (frontIsBlocked() && leftIsBlocked()) {
            putBeeper();
        } else {
            firstRow();
            middleBeeper();
        }
    }

    /**
     * Prerequisites: The Karel put the Beeper in the first time
     * Result: The Karel if frontIsClear put the Beeper & turnAround
     */
    private void firstRow() throws Exception {
        if (frontIsClear()) {
            putBeeper();
            checkStep();
            putBeeper();
            turnAround();
            gotoStep();
        } else putBeeper();
    }

    /**
     * Prerequisites: The Karel find middle the Beeper
     * Result: The Karel if frontIsClear got until  the Beeper is present
     */
    private void middleBeeper() throws Exception {
        if (frontIsClear()) {
            while (frontIsClear()) {
                goToBeeper();
                findMiddle();
            }
        } else pickBeeper();
    }

    /**
     * Prerequisites: The Karel clear the Beepers & find middle point
     * Result: pickBeepers, turnAround & goto in middle & putBeeper
     */
    private void findMiddle() throws Exception {
        pickBeeper();
        turnAround();
        gotoStep();
        checkMiddle();
        putBeeper();
        gotoStep();
        checkMiddle();
    }

    //
    /**
     * Prerequisites: The Karel checking middle the Beeper
     * Result: The Karel check if the Beeper Present & pickup him
     *        The Karel check which front on facing & turn opposite
     *
     */
    private void checkMiddle() throws Exception {
        if (beepersPresent()) {
            pickBeeper();
            turnAround();
            gotoStep();
            if (facingEast()) {
                turnRight();
            } else turnLeft();
        }
    }

    /**
     * Prerequisites: The Karel turnRight
     * Result: The Karel turnedLeft three times
     */
    public void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) turnLeft();
    }

    /**
     * Prerequisites: The Karel turnAround
     * Result: The Karel turned twice
     */
    public void turnAround() throws Exception {
        for (int i = 0; i < 2; i++) turnLeft();
    }

    /**
     * Prerequisites: The Karel check if frontIsClear to take a step
     * Result: The Karel checks if it is possible to take a step forward
     */
    public void gotoStep() throws Exception {
        if (frontIsClear()) move();
    }

    /**
     * Prerequisites: The Karel moving until frontIsClear
     * Result: The Karel checks if it is possible to take steps forward
     * & moving until the Wall Present
     */
    public void checkStep() throws Exception {
        while (frontIsClear()) move();
    }
    /**
     * Prerequisites: The Karel checks if it is forward the Beeper present
     * Result: The Karel goto forward until the Beeper present.
     */
    public void goToBeeper() throws Exception {
        while (!beepersPresent()) move();
    }
}