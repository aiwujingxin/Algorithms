package leetCode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/27 23:36
 */
public class LeetCode629_dp_2d_v3 {

    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n + 10][k + 10];
        long mod = (long) (1E9 + 7);
        dp[1][0] = 1;
        dp[1][1] = 0;
        //init
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j - i >= 0) {
                    dp[i][j] -= dp[i - 1][j - i];
                }
                dp[i][j] += mod;
                dp[i][j] %= mod;
            }
        }
        return (int) dp[n][k];
    }
}
