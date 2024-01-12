package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/20 21:01
 */
public class LeetCode1493 {

    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int n = nums.length;
        int max = 0;
        int cnt0 = 0;
        while (right < n) {
            if (nums[right] == 0) {
                cnt0++;
            }
            while (left < right && cnt0 > 1) {
                if (nums[left] == 0) {
                    cnt0--;
                }
                left++;
            }
            if (cnt0 <= 1) {
                max = Math.max(right - left, max);
            }
            right++;
        }
        return max;
    }
}
