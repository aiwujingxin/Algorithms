package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 18:43
 * @description 回溯树
 */
public class LeetCode52 {

    boolean[][] board;
    int n, ans;
    boolean[] c, p, q; // 列，撇，捺

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        this.n = n;
        this.board = new boolean[n][n];
        this.c = new boolean[n];
        this.p = new boolean[2 * n];
        this.q = new boolean[2 * n];
        backtrack(0);
        return ans;
    }

    private void backtrack(int i) {
        if (i == n) {
            ans++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (c[j] || p[i + j] || q[i - j + n]) {
                continue;
            }
            c[j] = p[i + j] = q[i - j + n] = true;
            board[i][j] = true;
            backtrack(i + 1);
            board[i][j] = false;
            c[j] = p[i + j] = q[i - j + n] = false;
        }
    }
}
