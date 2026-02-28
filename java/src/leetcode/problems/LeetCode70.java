package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 22:42
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        if (n < 2) return dp[n];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
