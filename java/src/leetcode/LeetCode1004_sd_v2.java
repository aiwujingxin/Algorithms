package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/18 00:04
 */
public class LeetCode1004_sd_v2 {

    public int longestOnes(int[] nums, int K) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        while (right < len) {
            freq[nums[right]]++;
            if (nums[right] == 1) {
                maxCount = Math.max(maxCount, freq[nums[right]]);
            }
            if (right - left + 1 > maxCount + K) {
                freq[nums[left]]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
