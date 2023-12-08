package leetcode.problems;

import java.util.TreeSet;

/**
 * @author jingxinwu
 * @date 2023/12/8 17:31
 */
public class LeetCode220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long floor = set.floor((long) nums[i]);
            Long ceil = set.ceiling((long) nums[i]);
            if (floor != null && (long) nums[i] - floor <= (long) valueDiff) {
                return true;
            }
            if (ceil != null && ceil - (long) nums[i] <= (long) valueDiff) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
