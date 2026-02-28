package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 18:02
 */
public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, i, j, chars, 0, new boolean[m][n])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, char[] word, int k, boolean[][] vis) {
        if (k == word.length - 1) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k] || vis[i][j]) {
            return false;
        }
        vis[i][j] = true;
        boolean res = backtrack(board, i + 1, j, word, k + 1, vis) ||
                backtrack(board, i - 1, j, word, k + 1, vis) ||
                backtrack(board, i, j + 1, word, k + 1, vis) ||
                backtrack(board, i, j - 1, word, k + 1, vis);
        vis[i][j] = false;
        return res;
    }
}
