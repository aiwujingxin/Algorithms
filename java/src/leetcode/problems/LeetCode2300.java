package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/26 12:41
 */
public class LeetCode2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = potions.length - leftBound(spells[i], potions, success);
        }
        return res;
    }

    private int leftBound(int spell, int[] potions, long success) {
        int l = 0;
        int r = potions.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if ((long) potions[mid] * spell < success) l = mid + 1;
            else r = mid;
        }
        if ((long) potions[l] * spell < success) {
            return l + 1;
        }
        return l;
    }
}
