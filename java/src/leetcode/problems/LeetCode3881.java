package leetcode.problems;

import knowledge.mathematics.MathUtil;

/**
 * @author wujingxinit@outlook.com
 * @date 6/8/26 23:09
 */
public class LeetCode3881 {

    public int countVisiblePeople(int n, int pos, int k) {
        long comb = MathUtil.C(n - 1, k);
        return (int) (2 * comb % 1000000007);
    }
}
