package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 01:11
 * @see LeetCode27
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length, left = 0, right = 0;

        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }
}
