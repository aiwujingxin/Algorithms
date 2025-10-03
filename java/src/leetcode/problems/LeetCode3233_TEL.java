package leetcode.problems;

import knowledge.mathematics.MathUtil;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:38
 */
public class LeetCode3233_TEL {

    public int nonSpecialCount(int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            int t = isSqrt(i);
            if (MathUtil.isPrime(t)) {
                res++;
            }
        }
        return r - l + 1 - res;
    }


    public int isSqrt(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (i * i == x) {
                return i;
            }
        }
        return -1;
    }
}
