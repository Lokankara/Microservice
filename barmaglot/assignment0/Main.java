file1.java
Main

import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;
import java.awt.*;

public class Main implements Directions {
    public static void main(String args[])  {
        Runnable task = new WorldRainbowify();
        Thread t1 = new Thread(task);
        t1.start();
        Robot Karel = new Robot (1, 1, North, 100, Color.BLUE);
        Karel.move();
    static {
        World.reset();
        World.readWorld("project.kwld");
        World.setDelay(10);
        World.setVisible(true);
    }
}
 
WorldRainbowify

import kareltherobot.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class WorldRainbowify implements Runnable{

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

JarrettBot

import kareltherobot.UrRobot;

import java.awt.*;

public class JarrettBot extends UrRobot {
    public JarrettBot(int street, int avenue, Direction direction, int beepers, Color color) {
        super(street, avenue, direction, beepers, color);
    }

    public void turnRight() {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }
}