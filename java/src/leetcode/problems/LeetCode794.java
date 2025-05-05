package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/5/25 16:03
 */
public class LeetCode794 {

    public boolean validTicTacToe(String[] board) {
        int m = board.length;
        int n = board[0].length();
        int[][] arr = new int[m][n];
        int xCnt = 0;
        int oCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) == 'X') {
                    arr[i][j] = 1;
                    xCnt++;
                }
                if (board[i].charAt(j) == 'O') {
                    arr[i][j] = -1;
                    oCnt++;
                }
            }
        }
        if (xCnt == 0 && oCnt == 0) {
            return true;
        }

        int xWin = 0;
        int oWin = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }
            if (sum == -3) {
                oWin++;
            }
            if (sum == 3) {
                xWin++;
            }
        }
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += arr[i][j];
            }
            if (sum == -3) {
                oWin++;
            }
            if (sum == 3) xWin++;
        }
        int lr = 0;
        for (int i = 0; i < n; i++) {
            lr += arr[i][i];
        }
        if (lr == -3) {
            oWin++;
        }
        if (lr == 3) {
            xWin++;
        }
        int rl = 0;
        for (int i = 0; i < n; i++) {
            rl += arr[i][n - i - 1];
        }
        if (rl == -3) {
            oWin++;
        }
        if (rl == 3) {
            xWin++;
        }
        if (xWin >= 1 && oWin >= 1) return false;
        if (xWin == 1) return xCnt == oCnt + 1;
        if (oWin == 1) {
            return oCnt == xCnt;
        }
        return xCnt == oCnt || xCnt == oCnt + 1;
    }
}
