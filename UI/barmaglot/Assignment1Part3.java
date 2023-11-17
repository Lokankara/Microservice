package com.shpp.p2p.cs.ppolyak;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {

  public void run() throws Exception {
    if (frontIsBlocked() && leftIsBlocked()) {putBeeper();}
    else {
    firstRow();middleBeep();}}

  private void firstRow() throws Exception {
    if (frontIsClear()) {
      putBeeper();
      moveUntil();
      putBeeper();
      turnRound();
      step();
    } else putBeeper();}


  private void middleBeep() throws Exception {
    if (frontIsClear()) {
      while (frontIsClear()) {
        moveBeep();
        rowBeep();}
    } else pickBeeper();}

  private void rowBeep() throws Exception {
    pickBeeper();
    turnRound();
    step();
    checkMiddle();
    putBeeper();
    step();
    checkMiddle();
  }


  private void checkMiddle() throws Exception {
    if (beepersPresent()) {
      pickBeeper();
      turnRound();
      step();
      if (facingEast()) {
        turnRight();
      } else turnLeft();
    }
  }


  public void turnRight() throws Exception {
    for (int i = 0; i < 3; i++)turnLeft();}

  public void turnRound() throws Exception {
    for (int i = 0; i < 2; i++)turnLeft();}

  public void step() throws Exception {
    if (frontIsClear())move();}

  public void moveUntil() throws Exception {
    while (frontIsClear()) move();}

  public void moveBeep() throws Exception {
    while (!beepersPresent()) move();}
}