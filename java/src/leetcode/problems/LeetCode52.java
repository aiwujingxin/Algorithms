package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 18:43
 * @description 子集树 or 排列树 ？
 */
public class LeetCode52 {

    boolean[][] board;
    int ans;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        this.board = new boolean[n][n];
        backtrack(n, 0);
        return ans;
    }

    private void backtrack(int n, int i) {
        if (i == n) {
            ans++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (place(i, j)) {
                board[i][j] = true;
                backtrack(n, i + 1);
                board[i][j] = false;
            }
        }
    }

    private boolean place(int row, int col) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j]) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (row + col == i + j || row - col == i - j) {
                    if (board[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
