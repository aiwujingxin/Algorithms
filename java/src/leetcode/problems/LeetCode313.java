package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/9 18:19
 * @see LeetCode264
 */
public class LeetCode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] indexes = new int[m];
        long[] dp = new long[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], primes[j] * dp[indexes[j]]);
            }
            for (int j = 0; j < m; j++) {
                if (dp[i] == dp[indexes[j]] * primes[j]) {
                    indexes[j]++;
                }
            }
        }
        return (int) dp[n - 1];
    }
}
