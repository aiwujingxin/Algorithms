package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 18:43
 * @description 回溯树
 */
public class LeetCode52 {

    int n, cnt;
    boolean[] c, p, q;

    public int totalNQueens(int n) {
        this.n = n;
        this.c = new boolean[n];
        this.p = new boolean[2 * n];
        this.q = new boolean[2 * n];
        backtrack(0);
        return cnt;
    }

    private void backtrack(int i) {
        if (i == n) {
            cnt++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (c[j] || p[i + j] || q[i - j + n]) continue;
            c[j] = p[i + j] = q[i - j + n] = true;
            backtrack(i + 1);
            c[j] = p[i + j] = q[i - j + n] = false;
        }
    }
}
