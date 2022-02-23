package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-18 1:45 PM
 */
public class LeetCode79 {

    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (find(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean find(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (col < 0 || col >= board[0].length
                || row < 0 || row >= board.length
                || word.charAt(index) != board[row][col]
                || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;

        if (find(board, row, col + 1, word, index + 1)
                || find(board, row, col - 1, word, index + 1)
                || find(board, row + 1, col, word, index + 1)
                || find(board, row - 1, col, word, index + 1)) {
            return true;
        }
        visited[row][col] = false;

        return false;
    }

}
