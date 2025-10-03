package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/11/25 13:45
 * @description 排序 贪心 中位数
 */
public class LeetCode3107 {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, mid = n / 2;
        long cnt = Math.abs(nums[mid] - k);
        for (int i = mid - 1; i >= 0 && nums[i] > k; i--) cnt += nums[i] - k;
        for (int i = mid + 1; i < n && nums[i] < k; i++) cnt += k - nums[i];
        return cnt;
    }
}
