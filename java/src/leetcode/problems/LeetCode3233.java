package leetcode.problems;

import knowledge.mathematics.impl.MathUtil;

/**
 * @author wujingxinit@outlook.com
 * @date 1/6/25 23:19
 */
public class LeetCode3233 {

    public int nonSpecialCount(int l, int r) {
        int cnt = 0;
        for (int i = 2; i * i <= r; i++) {
            if (i * i < l) {
                continue;
            }
            if (MathUtil.isPrime(i)) {
                cnt++;
            }
        }
        return r - l + 1 - cnt;
    }
}
