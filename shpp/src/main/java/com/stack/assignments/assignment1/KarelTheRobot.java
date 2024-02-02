package com.stack.assignments.assignment1;

public class KarelTheRobot {

    protected boolean leftIsBlocked() {
        return false;
    }

    protected boolean frontIsBlocked() {
        return false;
    }

    protected boolean BeepersPresent() {
        return false;
    }

    protected void putBeeper() {
    }

    protected void checkMiddle()
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

    protected void pickBeeper() {
    }

    protected void move() {
    }

    protected void turnLeft() {
    }


    protected void moveToBeeper() {
    }


    protected boolean frontIsClear() {
        return false;
    }

    protected boolean noBeepersPresent() {
        return false;
    }

    protected boolean beepersPresent() {
        return false;
    }

    protected boolean facingEast() {
        return false;
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
        while (!beepersPresent()) move();
    }
}
