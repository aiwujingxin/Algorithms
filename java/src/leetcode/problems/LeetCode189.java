package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 11:31
 */
public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
