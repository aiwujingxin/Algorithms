package leetCode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jingxinwu
 * @date 2021-12-12 3:06 PM
 */
public class LeetCode219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
