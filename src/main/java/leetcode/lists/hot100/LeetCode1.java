package leetcode.lists.hot100;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 22:50
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
