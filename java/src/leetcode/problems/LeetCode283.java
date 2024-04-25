package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 15:04
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, right, left);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
