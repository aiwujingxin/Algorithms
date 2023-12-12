package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 21:31
 */
public class LeetCode79 {

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = backtrack(board, i + 1, j, word, index + 1) || backtrack(board, i, j + 1, word, index + 1) || backtrack(board, i - 1, j, word, index + 1) || backtrack(board, i, j - 1, word, index + 1);
        visited[i][j] = false;
        return res;
    }
}
