package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 18:10
 */
public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(board, 0, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(char[][] board, int row, int n, List<String> list, List<List<String>> result) {
        if (row == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!valid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            list.add(new String(board[row]));
            backtrack(board, row + 1, n, list, result); // 以行为单位
            board[row][col] = '.';
            list.remove(list.size() - 1);
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
