package leetcode.lists.hot200;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 16:12
 */
public class LeetCode276 {
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
