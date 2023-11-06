package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 14:25
 */
public class LeetCode52 {

    int res;
    int n;
    char[][] board;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        this.n = n;
        board = new char[n][n];
        backtrack(0);
        return res;
    }

    private void backtrack(int row) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!valid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(row + 1);
            board[row][col] = '.';
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
