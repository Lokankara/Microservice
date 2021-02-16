public boolean isThereABotOnRtAndOnlyOneBeeperOnLeft() {
        turnLeft();
        move();
        if (nextToABeeper()) {
            pickBeeper();
            if (nextToABeeper()) {
                putBeeper();
                turnAround();
                move(2);
                turnLeft();
                return false;
            }
            putBeeper();
            turnAround();
            move(2);
            if (nextToARobot()) {
                turnAround();
                move();
                turnRight();
                return true;
            } else {
                turnAround();
                move();
                turnRight();
                return false;
            }
        } else {
            turnAround();
            move();
            turnLeft();
            return false;
        }
    }