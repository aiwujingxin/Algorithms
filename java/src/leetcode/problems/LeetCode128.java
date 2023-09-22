package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 19:35
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
        int max = 1;
        for (int num : nums) {
            int t = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    num--;
                    t++;
                }
            }
            max = Math.max(max, t);
        }
        return max;
    }
}
