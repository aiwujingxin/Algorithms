package leetcode.problems;

import java.util.TreeSet;

/**
 * @author jingxinwu
 * @date 2023/12/8 17:31
 */
public class LeetCode220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];
            Long floor = treeSet.floor(val);
            if (floor != null && val - floor <= valueDiff) {
                return true;
            }
            Long ceil = treeSet.ceiling(val);
            if (ceil != null && ceil - val <= valueDiff) {
                return true;
            }
            treeSet.add(val);
            if (treeSet.size() > indexDiff) {
                treeSet.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
