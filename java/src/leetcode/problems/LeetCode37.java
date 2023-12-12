package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/10 12:29
 * @description 回溯
 * 当前有矛盾就重新填，如果当前层都不符合，则需要返回上一层重新填
 */
public class LeetCode37 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, row, col, c)) {
                            // 填完传递给下一层
                            board[row][col] = c;
                            if (backtrack(board)) {
                                return true;
                            }
                            // 下一层无论填什么都不符合，那么得重新填
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, char c) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
