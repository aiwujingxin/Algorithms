package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 13:01
 */
public class LeetCode31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        int j = n - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1, n - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }
}
