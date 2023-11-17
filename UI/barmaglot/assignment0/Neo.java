     public void coordinateChange(int xDestination, int yDestination) {
        Direction initialDirection = getCurrentDirection();

        int xDifference = xDestination - xCoordinate;
        int yDifference = yDestination - yCoordinate;

        if(xDifference > 0) {
            faceThisDirection(East);
        }
        else if(xDifference < 0) {
            faceThisDirection(West);
        }
        for (int i = 0; i < Math.abs(xDifference); i++) {
            if (!frontIsClear()) {
                if (facingWest()) {
                    World.removeNSWall(getY(), getX() - 1);
                    move();
                    for (int j = 0; j < 2; j++) {
                        turnAround();
                    }
                    World.placeNSWall(getY(), getX(), 1);
                }
                if (facingEast()) {
                    World.removeNSWall(getY(), getX());
                    move();
                    for (int j = 0; j < 2; j++) {
                        turnAround();
                    }
                    World.placeNSWall(getY(), getX() - 1, 1);
                }
            } else {
                move();
            }
        }

        if(yDifference > 0) {
            faceThisDirection(North);
        }
        else if(yDifference < 0) {
            faceThisDirection(South);
        }
        for (int i = 0; i < Math.abs(yDifference); i++) {
            if (!frontIsClear()) {
                if (facingSouth()) {
                    World.removeEWWall(getY() - 1, getX());
                    move();
                    World.placeEWWall(getY(), getX(), 1);
                }
                if (facingNorth()) {
                    World.removeEWWall(getY(), getX());
                    move();
                    World.placeEWWall(getY() - 1, getX(), 1);
                }
            } else {
                move();
            }
        }

        faceThisDirection(initialDirection);
    }

    public Direction getCurrentDirection() {
        if (facingNorth()) {
            return North;
        } else if (facingSouth()) {
            return South;
        } else if (facingEast()) {
            return East;
        } else if (facingWest()) {
            return West;
        } else {
            return North;
        }
    }