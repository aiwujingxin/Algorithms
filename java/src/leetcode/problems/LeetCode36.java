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

        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                boolean[] visited = new boolean[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            continue;
                        }
                        if (visited[board[k][l] - '0']) {
                            return false;
                        }
                        visited[board[k][l] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
