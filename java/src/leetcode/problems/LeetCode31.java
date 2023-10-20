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
        // 从右向左找第一个下降的点
        int i = nums.length - 1;
        while (i >= 1 && nums[i - 1] >= nums[i]) {
            i--;
        }
        i--;
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // 从右向左找第一个比nums[i]大的数
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        if (j <= 0) {
            return;
        }
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
