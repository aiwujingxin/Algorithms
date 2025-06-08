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
        int max = 1;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int len = 1;
                int cur = num + 1;
                while (set.contains(cur)) {
                    len++;
                    cur++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
