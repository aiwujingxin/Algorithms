package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 13:10
 */
public class LeetCode1695 {

    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = 0;
        int[] freq = new int[100001];
        while (right < n) {
            sum += nums[right];
            freq[nums[right]]++;
            while (left < right && freq[nums[right]] > 1) {
                sum -= nums[left];
                freq[nums[left]]--;
                left++;
            }
            right++;
            res = Math.max(res, sum);
        }
        return sum;
    }
}
