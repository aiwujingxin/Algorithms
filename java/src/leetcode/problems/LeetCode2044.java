package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 17:01
 */
public class LeetCode2044 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int countMaxOrSubsets(int[] nums) {
        backtrack(nums, 0, 0);
        return max;
    }

    private void backtrack(int[] nums, int index, int or) {
        if (index > 0) {
            map.put(or, map.getOrDefault(or, 0) + 1);
            max = Math.max(max, map.get(or));
        }
        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, or | nums[i]);
        }
    }
}
