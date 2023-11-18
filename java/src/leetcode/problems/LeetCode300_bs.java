package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/25 23:00
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
            int insertIndex = binarySearch(dp, num);
            if (dp[insertIndex] >= num) {
                dp[insertIndex] = num;
            }
            res = Math.max(res, insertIndex);
        }
        return res;
    }

    public int binarySearch(int[] nums, int target) {
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
