package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/25 00:09
 */
public class LeetCode343_dfs {

    public int integerBreak(int n) {
        return helper(n, n);
    }

    public int helper(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;
        }

        if (n < m) {
            return helper(n, n);
        }

        if (n == m) {
            return helper(n, m - 1) + 1;
        }

        return helper(n, m - 1) + helper(n - m, m);
    }
}
