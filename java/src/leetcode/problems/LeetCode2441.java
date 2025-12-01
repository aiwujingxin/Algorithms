package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 11/28/25 17:18
 */
public class LeetCode2441 {

    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = -1;
        for (int s : set) {
            if (set.contains(-s)) {
                max = Math.max(max, Math.abs(s));
            }
        }
        return -1;
    }
}



