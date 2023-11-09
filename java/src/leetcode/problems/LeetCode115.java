package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 23:53
 */
public class LeetCode115 {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 不使用 s[i] 进行匹配，则有 f[i][j] = f[i - 1][j]
                dp[i][j] = dp[i - 1][j];
                // 使用 s[i] 进行匹配，则要求 s[i] == t[j]，然后有 f[i][j] += f[i - 1][j - 1]
                if (t.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
