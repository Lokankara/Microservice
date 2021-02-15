package com.shpp.p2p.cs.barmaglot.assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {
  public void run() throws Exception {
    for (int i = 0; i < 2; i++) moveUntil();
    moveClear();
    while (true) {
      while (!beepersPresent()) moveClear();
      turnAround(); moveClear();
      if (beepersPresent()) break;
      putBeeper(); moveClear();}
    putBeeper(); wall();
    while (frontIsClear()){
      if (beepersPresent()) pickBeeper(); moveClear();}
    pickBeeper(); turnAround();}

  private void moveClear() throws Exception {if(frontIsClear())move();}
  private void turnAround() throws Exception {for (int i = 0; i < 2; i++) turnLeft();}
  private void wall() throws Exception {while (frontIsClear())moveClear(); turnAround();}
  private void moveUntil() throws Exception {while (frontIsClear()){moveClear(); if (beepersPresent())break;} putBeeper(); turnAround();}}