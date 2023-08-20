package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/25 00:10
 */
public class LeetCode343_dp_opt {

    public int integerBreak(int n) {

        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }
}
