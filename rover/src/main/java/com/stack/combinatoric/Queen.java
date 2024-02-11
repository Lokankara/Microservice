package com.stack.combinatoric;

import java.util.Scanner;

public class Queen {

    public int[] move(Scanner scanner) {
        int[] arr = new int[8];
        int n = scanner.nextInt();
        int[] queens;
        for (int i = 0; i < n; i++) {
            queens = new int[8];
            for (int j = 0; j < 8; j++) {
                queens[j] = scanner.nextInt() - 1;
            }
            arr[i] = (permute(queens,
                              new int[8],
                              new int[15],
                              new int[15],
                              0,
                              0,
                              Integer.MAX_VALUE));
        }
        return arr;
    }

    private static int permute(
            int[] queens,
            int[] row,
            int[] black,
            int[] white,
            int col,
            int moves,
            int minMoves) {
        if (col == 8) {
            return Math.min(minMoves, moves);
        }
        for (int r = 0; r < 8; r++) {
            if (row[r] == 0 && black[r + col] == 0 && white[r - col + 7] == 0) {
                row[r] = black[r + col] = white[r - col + 7] = 1;
                minMoves = permute(queens, row, black, white, col + 1,
                                   moves + (queens[col] == r ? 0 : 1),
                                   minMoves);
                row[r] = black[r + col] = white[r - col + 7] = 0;
            }
        }
        return minMoves;
    }
}
