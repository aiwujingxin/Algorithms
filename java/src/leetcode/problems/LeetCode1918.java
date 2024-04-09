package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/23 11:53
 */
public class LeetCode1918 {

    public int kthSmallestSubarraySum(int[] nums, int k) {

        int min = Integer.MAX_VALUE, sum = 0;
        for (int x : nums) {
            min = Math.min(x, min);
            sum += x;
        }
        int l = min, r = sum;

        while (l < r) {
            int mid = l + r >> 1;
            if (countSubarrays(nums, mid) < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int countSubarrays(int[] nums, int target) {
        int sum = 0, count = 0;
        int n = nums.length;
        int left = 0, right = 0;

        while (right < n) {
            sum += nums[right++];
            while (sum > target) {
                sum -= nums[left++];
            }
            count += right - left;
        }
        return count;
    }
}
