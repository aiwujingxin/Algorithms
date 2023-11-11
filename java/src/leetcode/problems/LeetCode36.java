package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 15:12
 */
public class LeetCode36 {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        int n = board.length;

        boolean[] used;
        for (int i = 0; i < n; i++) {
            used = new boolean[10];
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (used[board[i][j] - '0']) {
                        return false;
                    }
                    used[board[i][j] - '0'] = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            used = new boolean[10];
            for (int i = 0; i < n; i++) {
                if (board[i][j] != '.') {
                    if (used[board[i][j] - '0']) {
                        return false;
                    }
                    used[board[i][j] - '0'] = true;
                }
            }
        }

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                used = new boolean[10];
                for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
                    for (int j = 3 * (col / 3); j < 3 * (col / 3) + 3; j++) {
                        if (board[i][j] != '.') {
                            if (used[board[i][j] - '0']) {
                                return false;
                            }
                            used[board[i][j] - '0'] = true;
                        }
                    }
                }

            }
        }
        return true;
    }
}
