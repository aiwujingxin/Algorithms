package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/1/25 11:53
 */
public class LeetCode3290 {

    public long maxScore(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {     // 枚举前 i 个 b
            for (int j = 1; j <= m; j++) { // 枚举前 j 个 a
                // 不选 b[i-1]
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                // 选 b[i-1] 和 a[j-1]
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + (long) a[j - 1] * b[i - 1]);
            }
        }
        return dp[n][m];
    }
}
