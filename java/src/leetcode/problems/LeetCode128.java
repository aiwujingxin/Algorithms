package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 11:05
 */
public class LeetCode128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int t = num;
                while (set.contains(t)) {
                    t++;
                }
                max = Math.max(max, t - num);
            }
        }
        return max;
    }
}
