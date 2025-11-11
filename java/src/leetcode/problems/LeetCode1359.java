package leetcode.problems;

import knowledge.mathematics.impl.MathUtil;

/**
 * @author wujingxinit@outlook.com
 * @date 11/11/25 15:27
 */
public class LeetCode1359 {

    long MOD = 1_000_000_007;

    // (2n)! / 2^n
    public int countOrders(int n) {
        long fact2n = 1;
        for (int i = 1; i <= 2 * n; i++) {
            fact2n = (fact2n * i) % MOD;
        }
        long invPowerOf2 = MathUtil.modInverse(MathUtil.modPow(2, n, MOD), MOD);
        return (int) ((fact2n * invPowerOf2) % MOD);
    }

    public class Solution_opt {

        public int countOrders(int n) {
            long count = 1;
            // count(i) = count(i-1) * i * (2*i - 1)
            for (int i = 2; i <= n; i++) {
                long term1 = 2L * i - 1;
                count = (count * term1) % MOD;
                count = (count * (long) i) % MOD;
            }
            return (int) count;
        }
    }
}
