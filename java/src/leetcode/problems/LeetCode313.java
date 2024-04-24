package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 15:36
 */
public class LeetCode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        int[] cnt = new int[primes.length];
        Arrays.fill(cnt, 1);
        for (int i = 2; i <= n; i++) {
            long min = Integer.MAX_VALUE;
            for (int p = 0; p < primes.length; p++) {
                if (dp[cnt[p]] * primes[p] < min) {
                    min = dp[cnt[p]] * primes[p];
                }
            }
            for (int p = 0; p < primes.length; p++) {
                if (dp[cnt[p]] * primes[p] == min) {
                    cnt[p]++;
                }
            }
            dp[i] = min;
        }
        return (int) dp[n];
    }
}
