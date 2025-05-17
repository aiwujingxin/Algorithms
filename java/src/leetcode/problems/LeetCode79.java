package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 18:02
 */
public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, chars, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] word, int i, int j, int k, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k] || visited[i][j]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = backtrack(board, word, i + 1, j, k + 1, visited) ||
                backtrack(board, word, i - 1, j, k + 1, visited) ||
                backtrack(board, word, i, j + 1, k + 1, visited) ||
                backtrack(board, word, i, j - 1, k + 1, visited);
        visited[i][j] = false;
        return res;
    }
}
