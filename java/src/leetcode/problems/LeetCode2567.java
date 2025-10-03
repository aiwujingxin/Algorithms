package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:27
 */
public class LeetCode2567 {

    public int minimizeSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        return Math.min(Math.min(a[n - 3] - a[0], a[n - 2] - a[1]), a[n - 1] - a[2]);
    }
}
