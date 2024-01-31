package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 11:08
 */
public class LeetCode2419 {

    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int maxLength = 0;
        int currLength = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == maxVal) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                currLength = 0;
            }
        }
        return maxLength;
    }
}
