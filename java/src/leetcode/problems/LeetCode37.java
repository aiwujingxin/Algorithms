package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:18
 */
public class LeetCode37 {

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (!valid(board, i, j, c)) {
                        continue;
                    }
                    board[i][j] = c;
                    if (backtrack(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public boolean valid(char[][] board, int row, int col, char c) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
