package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 12:30
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    t = Math.max(t, dp[j]);
                }
            }
            dp[i] = t + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS_opt(int[] nums) {
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
