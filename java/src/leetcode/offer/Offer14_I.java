package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 15:30
 */
public class Offer14_I {

    public int cuttingRope(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            // opt  j <= i / 2
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[i - j] * dp[j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
