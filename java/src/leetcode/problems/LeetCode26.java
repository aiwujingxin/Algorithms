package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 23:15
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == nums[left]) {
                right++;
            }
            if (right == nums.length) {
                return left + 1;
            }
            left++;
            swap(nums, left, right);
            right++;
        }
        return left + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }
}
