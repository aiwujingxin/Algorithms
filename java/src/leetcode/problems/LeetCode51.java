package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 18:22
 */
public class LeetCode51 {

    char[][] board;

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        this.board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(n, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int row, List<String> list) {
        if (row == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (place(board, row, j)) {
                board[row][j] = 'Q';
                list.add(new String(board[row]));
                backtrack(n, row + 1, list);
                board[row][j] = '.';
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean place(char[][] board, int row, int col) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (row + col == i + j || row - col == i - j) {
                    if (board[i][j] == 'Q') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
