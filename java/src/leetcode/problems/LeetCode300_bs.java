package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 22:51
 */
public class LeetCode300_bs {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        int res = 0;
        for (int num : nums) {
            int insertIndex = leftBound(dp, num);
            dp[insertIndex] = Math.min(dp[insertIndex], num);
            res = Math.max(res, insertIndex);
        }
        return res;
    }

    public int leftBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] < target) {
            return left + 1;
        }
        return left;
    }
}