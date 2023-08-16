package leetcode.problems;

import java.util.TreeSet;

/**
 * @author jingxinwu
 * @date 2021-08-19 2:20 上午
 */
public class LeetCode220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long floor = set.floor((long) nums[i]);
            Long ceil = set.ceiling((long) nums[i]);
            if (floor != null && (long) nums[i] - floor <= (long) t) {
                return true;
            }
            if (ceil != null && ceil - (long) nums[i] <= (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
