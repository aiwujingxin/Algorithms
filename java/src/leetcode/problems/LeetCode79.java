package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 18:02
 */
public class LeetCode79 {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bk(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bk(char[][] board, int i, int j, String word, int index) {
        if (index > word.length()) {
            return false;
        }
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = bk(board, i + 1, j, word, index + 1) ||
                bk(board, i, j + 1, word, index + 1) ||
                bk(board, i - 1, j, word, index + 1) ||
                bk(board, i, j - 1, word, index + 1);
        visited[i][j] = false;
        return res;
    }
}
