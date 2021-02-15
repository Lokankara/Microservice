package com.shpp.p2p.cs.barmaglot.assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    public void run() throws Exception {
//        leftUntil();
//        if (leftIsBlocked() && rightIsBlocked()) tower();
//        else {for (int i = 0; i < 3; i++){tower(); corners(); wallbuilt();}
//        tower(); turnRound(); leftUntil();}}
turnLeft();
tower();
moveUntil();
if (frontIsBlocked()) {corners();moveUntil(); }
if (frontIsBlocked()) {corners();moveUntil(); }
if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked()) {turnRound();}
while(leftIsBlocked()){moveClear();turnLeft();moveClear();turnRight();moveUntil();}
        turnLeft();
    moveClear();
        turnLeft();
        tower();
        moveUntil();
        if (frontIsBlocked()) {corners();moveUntil(); }
        if (frontIsBlocked()) {corners();moveUntil(); }
        if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked()) {turnRound();}
        while(leftIsBlocked()){moveClear();turnLeft();moveClear();turnRight();moveUntil();}
    }
private void tower() throws Exception {
    while (true) {
        if (!beepersPresent()) putBeeper();
        if (!frontIsClear()) break;
        moveClear();}}

    private void corners() throws Exception { moveRight();moveLeft();}
    private void moveLeft() throws Exception {turnLeft(); moveClear();}
    private void leftUntil() throws Exception {moveUntil(); turnLeft();}
    private void moveClear() throws Exception {if(frontIsClear()) move();}
    private void moveRight() throws Exception {turnRight(); moveClear();}
    private void moveUntil() throws Exception {while (frontIsClear()) moveClear();}
    private void turnRight() throws Exception {for (int i = 0; i < 3; i++) turnLeft();}
    private void turnRound() throws Exception {for (int i = 0; i < 2; i++) turnLeft();}
    private void wallbuilt() throws Exception { while (rightIsBlocked()){turnLeft(); moveUntil();} moveRight(); turnRight();}}