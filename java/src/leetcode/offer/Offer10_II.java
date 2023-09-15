package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 13:50
 */
public class Offer10_II {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % (1000000007);
        }
        return dp[n];
    }
}
