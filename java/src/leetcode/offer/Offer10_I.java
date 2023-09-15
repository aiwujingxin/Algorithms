package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 13:43
 */
public class Offer10_I {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % (1000000007);
        }
        return dp[n];
    }
}
