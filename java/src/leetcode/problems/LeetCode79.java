package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 21:31
 */
public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = backtrack(board, i + 1, j, word, index + 1, visited) ||
                backtrack(board, i, j + 1, word, index + 1, visited) ||
                backtrack(board, i - 1, j, word, index + 1, visited) ||
                backtrack(board, i, j - 1, word, index + 1, visited);
        visited[i][j] = false;
        return res;
    }
}
