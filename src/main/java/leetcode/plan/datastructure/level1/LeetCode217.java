package leetcode.plan.datastructure.level1;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 17:49
 */
public class LeetCode217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
