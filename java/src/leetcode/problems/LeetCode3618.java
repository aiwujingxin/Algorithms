package leetcode.problems;

import knowledge.mathematics.MathUtil;
import knowledge.mathematics.impl.Sieve;

/**
 * @author wujingxinit@outlook.com
 * @date 12/20/25 16:32
 */
public class LeetCode3618 {

    public long splitArray(int[] nums) {
        Sieve.EratosthenesSieve.initPrimes(nums.length);
        long a = 0;
        long b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Sieve.EratosthenesSieve.notPrime[i]) {
                b += nums[i];
            } else {
                a += nums[i];
            }
        }
        return Math.abs(a - b);
    }
}
