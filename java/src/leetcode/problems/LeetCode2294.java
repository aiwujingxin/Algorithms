package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/8 14:14
 */
public class LeetCode2294 {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - min > k) {
                res++;
                min = nums[i];
            }
        }
        return res;
    }
}
