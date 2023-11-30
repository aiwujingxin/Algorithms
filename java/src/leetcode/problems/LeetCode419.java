package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 15:10
 */
public class LeetCode419 {

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int m = board.length;
        int n = board[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int k = j + 1; k < n; k++) {
                        board[i][k] = '.';
                    }
                    for (int k = i + 1; k < n; k++) {
                        board[k][j] = '.';
                    }
                    res++;
                }
            }
        }
        return res;
    }
}
