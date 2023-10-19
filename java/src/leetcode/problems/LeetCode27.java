package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 23:26
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int left = 0;
        while (left < nums.length) {
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            int right = left + 1;
            while (right < nums.length && nums[right] == val) {
                right++;
            }
            if (left == nums.length || right == nums.length) {
                return left;
            }
            swap(nums, left, right);
            left++;
        }
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }
}
