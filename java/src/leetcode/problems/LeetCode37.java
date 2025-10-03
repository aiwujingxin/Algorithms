package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:18
 */
public class LeetCode37 {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        if (i == 9) return true; // 所有行处理完毕
        if (j == 9) return backtrack(board, i + 1, 0); // 当前行结束，处理下一行
        if (board[i][j] != '.') return backtrack(board, i, j + 1); // 跳过已填充单元格
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (backtrack(board, i, j + 1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
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
