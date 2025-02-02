package leetcode.problems;

import knowledge.mathematics.impl.Prime;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 14:56
 */
public class LeetCode762 {

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            if (Prime.isPrime(hammingWeight(i))) {
                ans++;
            }
        }
        return ans;
    }

    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}


