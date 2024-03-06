package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/6 15:00
 */
public class LeetCode2320 {

    public int countHousePlacements(int n) {
        if (n == 1) {
            return 4;
        }
        int mod = 1000000007;
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][1] = dp[i - 1][0];
        }
        long cnt = ((dp[n][0] + dp[n][1]) % mod);
        return (int) ((cnt * cnt) % mod);
    }
}
