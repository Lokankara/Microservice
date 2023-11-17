package com.shpp.p2p.cs.ppolyak.assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {

    /**
     * Prerequisites: The method run() has been decomposed on three methods
     * Result: The Karel searches & piking the Beeper.
     *        After all return to initial position
     */
    public void run() throws Exception {
        moveRight();
        searchBeeper();
        goHome();
    }

    /**
     * Prerequisites: The Karel return to initial position
     * Result: The Karel turnRound & twice moveRight. After all comes at home
     */
    private void goHome() throws Exception {
        turnAround();
        for (int i = 0; i < 2; i++)
            moveRight();
    }

    /**
     * Prerequisites: The Karel is looking for the Beeper & pickup him
     * Result: The Karel checks if it is possible to take a step forward
     *       and moveUntil the Beeper present.
     *       After all The Karel pickup the Beeper
     */
    private void searchBeeper() throws Exception {
        while (leftIsBlocked())
            moveClear();
        turnLeft();
        while (noBeepersPresent())
            moveClear();
        pickBeeper();

    }

    /**
     * Prerequisites: The Karel is goes as long as he sees the wall in front & turnRight
     * Result: The Karel checks if it is possible to take a step forward the Wall present.
     *       After all The Karel turnRight
     */
    private void moveRight() throws Exception {
        moveUntil();
        turnRight();

    }
    /**
     * Prerequisites: The Karel check if frontIsClear to move a step
     * Result: The Karel checks if it is possible to take a step forward. After all The Karel move
     */
    private void moveClear() throws Exception {
        if (frontIsClear()) move();
    }

    /**
     * Prerequisites: The Karel moveUntil it is possible
     * Result: The Karel checks frontIsClear & move
     */
    private void moveUntil() throws Exception {
        while (frontIsClear()) moveClear();
    }

    /**
     * Prerequisites: The Karel turnRight
     * Result: The Karel turnedLeft three times
     */
    private void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) turnLeft();
    }

    /**
     * Prerequisites: The Karel turnAround
     * Result: The Karel turned twice
     */
    private void turnAround() throws Exception {
        for (int i = 0; i < 2; i++) turnLeft();
    }
}