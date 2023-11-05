package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 00:28
 */
public class LeetCode279 {

    public int numSquares(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j * j <= n; j++) {
                if (i - j * j >= 0) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }
}
