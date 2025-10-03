package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:20
 */
public class LeetCode2779 {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int right = 1;
        Arrays.sort(nums);
        int left = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - k > nums[left] + k) {
                left++;
            } else {
                right++;
            }
        }
        return right;
    }
}
