package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 16:55
 */
public class LeetCode1004 {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int max = 0;
        while (right < n) {
            if (nums[right] == 0) {
                cnt++;
            }
            while (left < right && cnt > k) {
                if (nums[left] == 0) {
                    cnt--;
                }
                left++;
            }
            if (cnt <= k) {
                max = Math.max(right - left + 1, max);
            }
            right++;
        }
        return max;
    }
}
