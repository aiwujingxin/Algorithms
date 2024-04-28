package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 09:37
 */
public class LeetCode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        int[] index = new int[primes.length];
        Arrays.fill(index, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < index.length; j++) {
                dp[i] = Math.min(dp[i], dp[index[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }
        return (int) dp[n];
    }
}
