package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 15:39
 */
public class LeetCode2760 {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int left = 0;
        int n = nums.length;
        int max = 0;
        while (left < n) {
            while (left < n && (nums[left] % 2 != 0 || nums[left] > threshold)) {
                left++;
            }
            if (left == n) {
                return max;
            }
            int right = left + 1;
            while (right < n && nums[right] % 2 != nums[right - 1] % 2 && nums[right] <= threshold) {
                right++;
            }
            max = Math.max(max, right - left);
            left = right;
        }
        return max;
    }
}
