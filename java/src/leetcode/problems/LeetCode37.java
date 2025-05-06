package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:18
 */
public class LeetCode37 {

    public void solveSudoku(char[][] board) {
        bk(board);
    }

    private boolean bk(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (place(board, i, j, c)) {
                        board[i][j] = c;
                        if (bk(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean place(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c) return false;
        }
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }
        return true;
    }
}
