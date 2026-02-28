package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:18
 */
public class LeetCode37 {

    public void solveSudoku(char[][] board) {
        bk(board, 0, 0);
    }

    private boolean bk(char[][] b, int i, int j) {
        if (i == 9) return true;
        if (j == 9) return bk(b, i + 1, 0);
        if (b[i][j] != '.') return bk(b, i, j + 1);
        for (char c = '1'; c <= '9'; c++) {
            if (ok(b, i, j, c)) {
                b[i][j] = c;
                if (bk(b, i, j + 1)) return true;
                b[i][j] = '.';
            }
        }
        return false;
    }

    private boolean ok(char[][] b, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (b[row][i] == c || b[i][col] == c) return false;
        }
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (b[i][j] == c) return false;
            }
        }
        return true;
    }
}
