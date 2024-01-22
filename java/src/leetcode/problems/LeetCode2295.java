package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 16:06
 */
public class LeetCode2295 {

    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] operation : operations) {
            nums[map.get(operation[0])] = operation[1];
            map.put(operation[1], map.get(operation[0]));
        }
        return nums;
    }
}
