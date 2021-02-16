public void lineSorter() {
        int lineAmount = 0;
        turnRight();
        while (nextToABeeper()) {
            lineAmount++;
            move();
        }
        int lineHeigths[] = new int[lineAmount];
        turnAround();
        for (int i = 0; i < lineAmount; i++) {
            move();
        }
        turnRight();
        for (int i = 0; i < lineAmount; i++) {
            int lineHeight = 0;
            while (nextToABeeper()) {
                pickBeeper();
                move();
                lineHeight++;
            }
            turnAround();
            for (int j = 0; j < lineHeight; j++) {
                move();
            }
            turnAround();
            turnRight();
            move();
            turnLeft();
            lineHeigths[i] = lineHeight;
        }
        turnLeft();
        for (int i = 0; i < lineAmount; i++) {
            move();
        }
        turnRight();
        Arrays.sort(lineHeigths);
        for (int i = 0; i < lineAmount; i++) {
            for (int j = 0; j < lineHeigths[i]; j++) {
                putBeeper();
                move();
            }
            turnAround();
            for (int x = 0; x < lineHeigths[i]; x++) {
                move();
            }
            turnAround();
            turnRight();
            move();
            turnLeft();
        } 
    }