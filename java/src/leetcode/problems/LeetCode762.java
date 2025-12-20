package leetcode.problems;

import knowledge.mathematics.MathUtil;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 14:56
 */
public class LeetCode762 {

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            if (MathUtil.isPrime(Integer.bitCount(i))) {
                ans++;
            }
        }
        return ans;
    }
}


