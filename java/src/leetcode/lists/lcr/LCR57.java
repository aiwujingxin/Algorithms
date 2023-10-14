package leetcode.lists.lcr;

import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 22:12
 */
public class LCR57 {

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

