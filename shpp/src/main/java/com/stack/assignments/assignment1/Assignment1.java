package com.stack.assignments.assignment1;

public class Assignment1
        extends KarelTheRobot {

    public void run()
            throws Exception {
        firstRow();
        middleBeep();
    }

    private void firstRow()
            throws Exception {
        if (frontIsClear()) {
            putBeeper();
            moveUntil();
            putBeeper();
            turnRound();
            step();
        } else putBeeper();
    }


    private void middleBeep()
            throws Exception {
        if (frontIsClear()) {
            while (frontIsClear()) {
                moveToBeeper();
                rowBeep();
            }
        } else pickBeeper();
    }

    private void rowBeep()
            throws Exception {
        pickBeeper();
        turnRound();
        step();
        checkMiddle();
        putBeeper();
        step();
        checkMiddle();
    }


    private void checkMidPoint()
            throws Exception {
        if (beepersPresent()) {
            pickBeeper();
            turnRound();
            step();
            if (facingEast()) {
                turnRight();
            } else turnLeft();
        }
    }


    public void turnRight()
            throws Exception {
        for (int i = 0; i < 3; i++) turnLeft();
    }

    public void turnRound()
            throws Exception {
        for (int i = 0; i < 2; i++) turnLeft();
    }

    public void step()
            throws Exception {
        if (frontIsClear()) move();
    }

    public void moveUntil()
            throws Exception {
        while (frontIsClear()) move();
    }

    public void moveBeep()
            throws Exception {
        while (!BeepersPresent()) move();
    }

}
