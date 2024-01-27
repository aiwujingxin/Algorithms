package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 11:08
 */
public class LeetCode2909 {

    public int minimumSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] left = new int[n];
        int lMin = nums[0];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = lMin;
            if (nums[i] < lMin) {
                lMin = nums[i];
            }
        }
        int[] right = new int[n];
        int rMin = nums[n - 1];
        right[n - 1] = rMin;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = rMin;
            if (nums[i] < rMin) {
                rMin = nums[i];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (left[i] < nums[i] && right[i] < nums[i]) {
                res = Math.min(res, nums[i] + left[i] + right[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
