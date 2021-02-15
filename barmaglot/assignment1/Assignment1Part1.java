package com.shpp.p2p.cs.barmaglot.assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {
    public void run() throws Exception {
        moveRight();
        while (leftIsBlocked()) moveClear();
        turnLeft();
        while (!beepersPresent()) moveClear();
        pickBeeper(); turnRound();
        for (int i = 0; i < 2; i++) moveRight();}

    private void moveRight() throws Exception {moveUntil(); turnRight();}
    private void moveClear() throws Exception {if(frontIsClear()) move();}
    private void moveUntil() throws Exception {while (frontIsClear()) moveClear();}
    private void turnRight() throws Exception {for (int i = 0; i < 3; i++) turnLeft();}
    private void turnRound() throws Exception {for (int i = 0; i < 2; i++) turnLeft();}}