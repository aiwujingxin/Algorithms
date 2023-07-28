package leetcode.lists.hot100;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 23:35
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 0;

        for (int j : nums) {
            int num = j;
            int temp = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    num++;
                    temp++;
                }
                max = Math.max(temp, max);
            }
        }
        return max;
    }
}
