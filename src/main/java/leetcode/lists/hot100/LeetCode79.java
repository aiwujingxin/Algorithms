package leetcode.lists.hot100;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 19:11
 */
public class LeetCode79 {

    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || visited[i][j]
                || word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j - 1, index + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
