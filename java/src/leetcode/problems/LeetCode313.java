package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 09:37
 */
public class LeetCode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        long[] dp = new long[n];
        dp[0] = 1;
        int[] idx = new int[len];
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min = Math.min(min, dp[idx[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < len; j++) {
                if (dp[idx[j]] * primes[j] == min) idx[j]++;
            }
        }
        return (int) dp[n - 1];
    }
}
