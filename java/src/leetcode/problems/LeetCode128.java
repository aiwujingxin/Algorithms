package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 16:42
 */
public class LeetCode128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 0;
        for (Integer n : set) {
            if (!set.contains(n - 1)) {
                int t = n;
                int len = 0;
                while (set.contains(t)) {
                    len++;
                    t++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
