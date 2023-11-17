package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 18:41
 */
public class LeetCode343 {

    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
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
            int t = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = dp[j] * dp[i - j];
                if (t < product) {
                    t = product;
                }
            }
            dp[i] = t;
        }
        return dp[n];
    }
}
