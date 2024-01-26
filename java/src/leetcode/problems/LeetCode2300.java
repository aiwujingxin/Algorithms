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

        int left = 0;
        int right = potions.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            long t = (long) potions[mid] * spell;
            if (t < success) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if ((long) potions[left] * spell < success) {
            return left + 1;
        }
        return left;
    }
}
