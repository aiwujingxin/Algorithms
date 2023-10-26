package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/26 10:22
 */
public class LeetCode79 {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
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
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = backtrack(board, i + 1, j, word, index + 1) ||
                backtrack(board, i, j + 1, word, index + 1) ||
                backtrack(board, i - 1, j, word, index + 1) ||
                backtrack(board, i, j - 1, word, index + 1);

        visited[i][j] = false;
        return res;
    }
}
