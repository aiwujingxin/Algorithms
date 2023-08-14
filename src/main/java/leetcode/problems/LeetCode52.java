package leetcode.problems;

import java.util.Arrays;

public class LeetCode52 {

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] i : board) {
            Arrays.fill(i, '.');
        }
        return backtrack(0, board);
    }

    public int backtrack(int col, char[][] board) {
        if (col == board.length) {
            return 1;
        }
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            if (valid(board, row, col)) {
                board[row][col] = 'Q';
                count += backtrack(col + 1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }

    private boolean valid(char[][] board, int x, int y) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q') {
                    if (x == i || y == j || x + y == i + j || x - y == i - j) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
