package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 13:00
 */
public class LeetCode674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;
        int countNum = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] > nums[right - 1]) {
                right++;
            }
            countNum = Math.max(countNum, right - left);
            left = right;
            right++;
        }
        return countNum;
    }
}
