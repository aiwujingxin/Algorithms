package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/10/26 23:57
 */
public class LeetCode3281 {

    public int maxPossibleScore(int[] start, int d) {
        int n = start.length;
        Arrays.sort(start);
        int l = 0;
        int r = start[n - 1] + d - start[0] + d;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(start, d, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] start, int d, int mid) {
        int n = start.length;
        long pre = start[0];
        for (int i = 1; i < n; i++) {
            long minPossible = pre + mid;
            if (minPossible > start[i] + d) {
                return false; // Cannot achieve the minGap
            }
            pre = Math.max(start[i], minPossible);
        }
        return true;
    }
}
