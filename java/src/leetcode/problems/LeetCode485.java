package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/7 10:52
 */
public class LeetCode485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int max = 0;

        while (left < n) {
            while (left < n && nums[left] == 0) {
                left++;
            }
            int cnt = 0;
            int right = left;
            while (right < n && nums[right] == 1) {
                right++;
                cnt++;
            }
            max = Math.max(cnt, max);
            left = right;
        }
        return max;
    }
}
