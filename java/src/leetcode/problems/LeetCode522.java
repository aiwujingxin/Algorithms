package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/21 21:19
 * @see LeetCode1143
 */
public class LeetCode522 {

    public int findLUSlength(String[] strs) {
        int n = strs.length, ans = -1;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (check(strs[i], strs[j])) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans = Math.max(strs[i].length(), ans);
            }
        }
        return ans;
    }

    boolean check(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (m < n) {
            return false;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] == n) {
                    return true;
                }
            }
        }
        return false;
    }
}
