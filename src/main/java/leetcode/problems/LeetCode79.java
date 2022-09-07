package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-06-26 3:28 下午
 */
public class LeetCode79 {

    static boolean[][] visited;

    private static boolean find(char[][] board, int row, int col, String word, int c) {
        if (c == word.length()) {
            return true;
        }

        if (col < 0 || col >= board[0].length
                || row < 0 || row >= board.length
                || word.charAt(c) != board[row][col]
                || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        if (find(board, row, col + 1, word, c + 1)
                || find(board, row, col - 1, word, c + 1)
                || find(board, row + 1, col, word, c + 1)
                || find(board, row - 1, col, word, c + 1)) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int c = 0;
        visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (find(board, row, col, word, c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
