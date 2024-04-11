package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/12 00:54
 */
public class LeetCode51 {
    List<List<String>> res;
    int n;

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        this.res = new ArrayList<>();
        this.n = n;
        bk(board, 0);
        return res;
    }

    private void bk(char[][] board, int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (place(board, row, col)) {
                board[row][col] = 'Q';
                bk(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean place(char[][] board, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == row + col || j - i == col - row) {
                    if (board[i][j] == 'Q')
                        return false;
                }
            }
        }
        return true;
    }
}
