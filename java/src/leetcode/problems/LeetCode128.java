package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 16:42
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
        for (int num : set) {
            int n = num;
            int cnt = 1;
            if (!set.contains(n - 1)) {
                while (set.contains(n + 1)) {
                    cnt++;
                    n++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
