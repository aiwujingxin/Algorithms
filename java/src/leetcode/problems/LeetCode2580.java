package leetcode.problems;

import knowledge.mathematics.impl.MathUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 7/26/25 18:42
 */
public class LeetCode2580 {

    public int countWays(int[][] ranges) {
        int mod = 1_000_000_007;
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int group = 1;
        int maxR = -1;
        for (int[] p : ranges) {
            if (p[0] > maxR) {
                group++;
            }
            maxR = Math.max(maxR, p[1]);
        }
        return (int) MathUtil.modPow(2, group, mod);
    }
}
