package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 00:11
 */
public class LeetCode36 {

    //https://leetcode.com/problems/valid-sudoku/discuss/2586924/Best-Solution-oror-Java-oror-Upvote-if-you-like-this

    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }

    static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (isSafe(board, i, j, board[i][j])) {
                        board[i][j] = '.';
                        return solve(board);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isSafe(char[][] board, int i, int j, char k) {
        board[i][j] = '.'; // it will return false if the index is not marked as '.' , as we're searching for the same element
        for (int l = 0; l < 9; l++) {
            // to check row
            if (board[i][l] == k) {
                return false;
            }
            // to check col
            if (board[l][j] == k) {
                return false;
            }
        }

        int len = (int) Math.sqrt(board.length);
        int rowStart = i - i % len, colStart = j - j % len;

        for (int m = rowStart; m < rowStart + len; m++) {
            for (int n = colStart; n < colStart + len; n++) {
                if (board[m][n] == k) { // to check the entire 3x3 matrix
                    return false;
                }
            }
        }
        return true;
    }
}
