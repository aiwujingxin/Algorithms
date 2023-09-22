package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 14:56
 */
public class Offer12 {

    char[][] board;
    boolean[][] visited;
    String word;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        this.board = board;
        this.word = word;

        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = dfs(i + 1, j, index + 1) ||
                dfs(i - 1, j, index + 1) ||
                dfs(i, j + 1, index + 1) ||
                dfs(i, j - 1, index + 1);
        visited[i][j] = false;
        return res;
    }
}
