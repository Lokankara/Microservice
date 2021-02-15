package com.shpp.p2p.cs.barmaglot.assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {
    public void run() throws Exception {
        while(true){
            if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked())break;
        while(true){
            if (frontIsBlocked()) break;
            moveClear(); putBeeper(); moveClear();}
            if (beepersPresent()){turnLeft(); moveClear(); turnLeft(); row();}
            else {turnLeft(); moveClear(); turnLeft(); putBeeper(); moveClear(); row();}
            if (frontIsBlocked() && rightIsBlocked()) break;
            turnRight(); moveClear(); turnRight();}
        turnLeft(); moveClear();
        if (beepersPresent()){turnRight();turnRight();moveClear();turnRight();even();}}

    private void even() throws Exception {while (true){
        if (beepersPresent()) pickBeeper(); moveClear(); moveClear();
        if (frontIsBlocked() && leftIsBlocked()) break;}
        if (beepersPresent()) pickBeeper(); turnRight(); moveClear();
        if (!beepersPresent()) {turnLeft(); turnLeft(); moveClear(); putBeeper();}}
    private void moveClear() throws Exception {if(frontIsClear()) move();}
    private void turnRight() throws Exception {for (int i = 0; i < 3; i++) turnLeft();}
    private void row() throws Exception {while(true) {if(frontIsBlocked()) break; moveClear(); putBeeper(); moveClear();}}}
