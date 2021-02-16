    private static void ch3HW_11(JarrettBot robot) {
        for (int i = 0; i < 4; i++)
            robot.buildCorner();
    }

    public void buildCorner() {
        for (int i = 0; i < 2; i++) {
            putBeeper();
            move();
        }
        turnLeft();
        for (int i = 0; i < 3; i++) {
            putBeeper();
            move();
        }
        for (int i = 0; i < 2; i++) {
            turnRight();
            move();
        }
    }