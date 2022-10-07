package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/23 17:02
 */
public class LeetCode79 {

    //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
    //"ABCB"

    //fixed
    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] ||
                word.charAt(index) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (dfs(board, i + 1, j, word, index + 1) ||
                dfs(board, i, j + 1, word, index + 1) ||
                dfs(board, i - 1, j, word, index + 1) ||
                dfs(board, i, j - 1, word, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
