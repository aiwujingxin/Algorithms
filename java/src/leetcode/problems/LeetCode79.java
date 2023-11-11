package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 21:09
 */
public class LeetCode79 {

    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || used[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        used[row][col] = true;
        boolean res = backtrack(row + 1, col, index + 1, board, word) ||
                backtrack(row, col + 1, index + 1, board, word) ||
                backtrack(row - 1, col, index + 1, board, word) ||
                backtrack(row, col - 1, index + 1, board, word);
        used[row][col] = false;
        return res;
    }
}
