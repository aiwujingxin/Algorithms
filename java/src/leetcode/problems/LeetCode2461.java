package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/5 00:07
 */
public class LeetCode2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long ans = 0;
        long sum = 0;

        int count = 0;
        int[] arr = new int[100001];
        while (right < nums.length) {
            sum += nums[right];
            arr[nums[right]]++;
            if (arr[nums[right]] == 1) {
                count++;
            }
            while (right - left + 1 > k || right - left + 1 > count) {
                sum -= nums[left];
                arr[nums[left]]--;
                if (arr[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            if (right - left + 1 == k) {
                ans = Math.max(ans, sum);
            }
            right++;
        }
        return ans;
    }
}
