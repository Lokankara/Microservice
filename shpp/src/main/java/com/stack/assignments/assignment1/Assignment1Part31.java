package com.stack.assignments.assignment1;

public class Assignment1Part31
        extends KarelTheRobot {

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
}
