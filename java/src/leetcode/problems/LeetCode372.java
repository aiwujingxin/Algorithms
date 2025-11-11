package leetcode.problems;

import knowledge.mathematics.impl.MathUtil;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 17:04
 */
public class LeetCode372 {

    public int superPow(int a, int[] b) {
        int mod = 1337;
        long res = 1;
        for (int j : b) {
            res = MathUtil.modPow(res, 10, mod) * MathUtil.modPow(a, j, mod) % mod;
        }
        return (int) res;
    }
}
