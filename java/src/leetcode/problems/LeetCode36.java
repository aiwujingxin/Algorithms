package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 10:37
 */
public class LeetCode36 {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[10];
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '.') {
                    if (visited[board[i][j] - '0']) {
                        return false;
                    }
                    visited[board[i][j] - '0'] = true;
                }

            }
        }

        for (int j = 0; j < m; j++) {
            boolean[] visited = new boolean[10];
            for (int i = 0; i < n; i++) {
                if (board[i][j] != '.') {
                    if (visited[board[i][j] - '0']) {
                        return false;
                    }
                    visited[board[i][j] - '0'] = true;
                }
            }
        }

        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < m; j += 3) {
                boolean[] visited = new boolean[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            if (visited[board[k][l] - '0']) {
                                return false;
                            }
                            visited[board[k][l] - '0'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
