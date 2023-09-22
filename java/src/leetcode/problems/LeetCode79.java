package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023-09-19 16:18 下午
 */
public class LeetCode79 {

    String word;

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        visited = new boolean[m][n];
        this.word = word;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = backtrack(board, i + 1, j, index + 1) ||
                backtrack(board, i, j + 1, index + 1) ||
                backtrack(board, i - 1, j, index + 1) ||
                backtrack(board, i, j - 1, index + 1);
        visited[i][j] = false;
        return res;
    }
}
