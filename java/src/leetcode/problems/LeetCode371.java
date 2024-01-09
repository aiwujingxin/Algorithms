package leetcode.problems;

import knowledge.datastructure.string.impl.BigDecimal;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/12/24 22:18
 */
public class LeetCode371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1; //进位
        }
        return a;
    }

    public int getSum_self(int a, int b) {
        int one = Math.max(a, b);
        int two = Math.min(a, b);
        long res;
        if (two > 0) {
            res = Long.parseLong(new BigDecimal().addStrings(String.valueOf(one), String.valueOf(two)));
        } else if (one < 0) {
            res = -1 * Long.parseLong(new BigDecimal().addStrings(String.valueOf(-one), String.valueOf(-two)));
        } else {
            res = Long.parseLong(new BigDecimal().subtract(String.valueOf(one), String.valueOf(-two)));
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }
}
