    public void mazeWalker() {
        while (!facingEast()) {
            turnLeft();
        }
        while (!nextToABeeper()) {
            if(!frontIsClear()) {
                turnLeft();
            } else {
                move();
                turnRight();
                if(frontIsClear()) {
                    move();
                    turnRight();
                    if(frontIsClear()) {
                        move();
                    } else {
                        turnLeft();
                    }
                } else {
                    turnLeft();
                }
            }
        }
    }