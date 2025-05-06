package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:11
 */
public class LeetCode36 {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return true;
        }
        int n = board.length;
        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[10];
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (vis[board[i][j] - '0']) {
                    return false;
                }
                vis[board[i][j] - '0'] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean[] vis = new boolean[10];
            for (int i = 0; i < n; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (vis[board[i][j] - '0']) {
                    return false;
                }
                vis[board[i][j] - '0'] = true;
            }
        }

        for (int row = 0; row < n; row += 3) {
            for (int col = 0; col < n; col += 3) {
                boolean[] box = new boolean[10];
                for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
                    for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        if (box[board[i][j] - '0']) {
                            return false;
                        }
                        box[board[i][j] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
