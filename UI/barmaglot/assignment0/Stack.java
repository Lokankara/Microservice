import kareltherobot.*;
import sun.security.krb5.KrbApRep;

import java.awt.*;

public class KarelRun implements Directions {

    public static void main(String args[]) {
        /*
        Runnable task = new WorldRainbowify();
        Thread t1 = new Thread(task);
        t1.start();
        */

        JarrettBot Karel = new JarrettBot(1, 5, North, 100, Color.BLUE);
    } static {
        World.readWorld("KarelLib/blank.kwld");
        World.setDelay(30);
        World.setVisible(true);
    }

    private static void buildPins(JarrettBot robot) {
        robot.putBeeper();
        robot.move();
        robot.turnRight();
        robot.move();
        robot.putBeeper();
        robot.turnAround();
        robot.move(2);
        robot.putBeeper();
        robot.turnAround();
        robot.move();
        robot.turnRight();
        robot.move();
        robot.turnAround();
    }

    private static void climbStair(JarrettBot robot) {
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.move();
    }

    private static void ch3HW(JarrettBot robot) {
        buildPins(robot);
        robot.move(2);
        robot.putBeeper();
        robot.turnLeft();
        robot.move(2);
        robot.turnRight();
        buildPins(robot);
        robot.turnRight();
        robot.move(4);
        robot.turnLeft();
        buildPins(robot);
    }

}



import kareltherobot.*;
import kareltherobot.Robot;

import java.awt.*;

public class JarrettBot extends Robot {

    private int xCoordinate;
    private int yCoordinate;
    private Direction currentDirection;
    private int beeperCount;

    public JarrettBot(int street, int avenue, Direction direction, int beepers, Color color) {
        super(street, avenue, direction, beepers, color);

        xCoordinate = avenue;
        yCoordinate = street;
        currentDirection = direction;
        beeperCount = beepers;
    }

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            if (frontIsClear()) {
                super.move();

                if (facingNorth()) {
                    yCoordinate++;
                } else if (facingSouth()) {
                    yCoordinate--;
                } else if (facingEast()) {
                    xCoordinate++;
                } else if (facingWest()) {
                    xCoordinate--;
                }
            } else {
                System.err.println("Error shutoff: Ran into wall");
                turnOff();
                break;
            }
        }
    }

    public void setX(int xCoordinate) {
        xCoordinate = this.xCoordinate;
    }

    public int getX() {
        return xCoordinate;
    }

    public void setY(int yCoordinate) {
        yCoordinate = this.yCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }

    public void coordinateChange(int xDestination, int yDestination) {
        Direction initialDirection = currentDirection;

        int xDifference = xDestination - xCoordinate;
        int yDifference = yDestination - yCoordinate;

        if(xDifference > 0) {
            faceThisDirection(East);
        }
        else if(xDifference < 0) {
            faceThisDirection(West);
        }
        move(Math.abs(xDifference));

        if(yDifference > 0) {
            faceThisDirection(North);
        }
        else if(yDifference < 0) {
            faceThisDirection(South);
        }
        move(Math.abs(yDifference));

        faceThisDirection(initialDirection);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setBeeperCount(int beeperCount) {
        beeperCount = this.beeperCount;
    }

    public int getBeeperCount() {
        return beeperCount;
    }

    public boolean isFacingDirection(Direction currentDirection) {
        boolean isFacing = false;

        if (currentDirection == North && this.facingNorth()) {
            isFacing = true;
        } else if (currentDirection == South && this.facingSouth()) {
            isFacing = true;
        } else if (currentDirection == East && this.facingEast()) {
            isFacing = true;
        } else if (currentDirection == West && this.facingWest()) {
            isFacing = true;
        }

        return isFacing;
    }

    public void faceThisDirection(Direction newDirection) {
        while (!this.isFacingDirection(newDirection)) {
            turnLeft();
        }
    }

    public void turnRight() {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    public void turnAround() {
        for (int i = 0; i < 2; i++) {
            turnLeft();
        }
    }

    public void moveOverRow() {
        turnRight();
        move();
        turnLeft();
    }

    public void moveToWall() {
        while (frontIsClear()) {
            move();
        }
    }

    public void moveMile() {
        for (int i = 0; i < 8; i++) {
            move();
        }
    }

    public void moveBack() {
        turnAround();
        move();
        turnAround();
    }

    public void moveKiloMile() {
        for (int i = 0; i < 125; i++) {
            move();
        }
    }

    public void beeperRow(int number, boolean returnHome) {
        for (int i = 0; i < number; i++) {
            putBeeper();
            move();
        }
        if (returnHome) {
            turnAround();
            for (int i = 0; i < number; i++) {
                move();
            }
            turnAround();
        }
    }
}




mport kareltherobot.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class WorldRainbowify implements Runnable {

    public void run() {
        Random r = new Random();
        ArrayList<Color> rainbowcolors = new ArrayList();
        rainbowcolors.add(Color.RED);
        rainbowcolors.add(Color.BLUE);
        rainbowcolors.add(Color.GREEN);
        rainbowcolors.add(Color.YELLOW);
        rainbowcolors.add(Color.PINK);
        rainbowcolors.add(Color.CYAN);
        rainbowcolors.add(Color.ORANGE);
        while (true) {
            try {
                Thread.sleep(500);
                Color a = rainbowcolors.get(r.nextInt(rainbowcolors.size()));
                World.setWorldColor(a);
                rainbowcolors.remove(a);
                Color b = rainbowcolors.get(r.nextInt(rainbowcolors.size()));
                World.setStreetColor(b);
                rainbowcolors.remove(b);
                Color c = rainbowcolors.get(r.nextInt(rainbowcolors.size()));
                World.setBeeperColor(c);
                rainbowcolors.remove(c);
                Color d = rainbowcolors.get(r.nextInt(rainbowcolors.size()));
                World.setNeutroniumColor(d);
                rainbowcolors.add(a);
                rainbowcolors.add(b);
                rainbowcolors.add(c);
            } catch (InterruptedException ex) {
                System.out.println("Unexpected Error: " + ex.getMessage());
            }
        }
    }
}