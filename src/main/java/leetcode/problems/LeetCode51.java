package leetcode.problems;

import java.util.*;

public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        // 初始化
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(char[][] board, int row, int n, List<String> tempList, List<List<String>> result) {
        if (row == n) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!valid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';
            tempList.add(new String(board[row]));
            backtrack(board, row + 1, n, tempList, result); // 以行为单位
            board[row][col] = '.';
            tempList.remove(tempList.size() - 1);
        }
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
