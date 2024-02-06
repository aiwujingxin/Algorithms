package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/6 14:42
 */
public class LeetCode2971 {

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        long max = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < presum[i]) {
                max = Math.max(nums[i] + presum[i], max);
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
