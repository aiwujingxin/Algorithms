package leetcode.hot100;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/13 11:52
 */
public class LeetCode10_dfs_reverse_memo {
    int[][] dp;

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(s, p, m, n);
    }

    public boolean f(String s, String p, int m, int n) {
        if (n == 0) {
            return m == 0;
        }
        if (m == 0) {
            return p.charAt(n - 1) == '*' && f(s, p, m, n - 2);
        }
        if (dp[m][n] != -1) {
            return dp[m][n] == 1;
        }
        boolean res = false;
        if (s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '.') {
            res = f(s, p, m - 1, n - 1);
        } else if (p.charAt(n - 1) == '*') {
            if (s.charAt(m - 1) == p.charAt(n - 2) || p.charAt(n - 2) == '.') {
                res = f(s, p, m - 1, n);
            }
            res = res || f(s, p, m, n - 2);
        }
        dp[m][n] = res ? 1 : 0;
        return res;
    }
}
