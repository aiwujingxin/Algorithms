package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:49
 */
public class LeetCode31 {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
