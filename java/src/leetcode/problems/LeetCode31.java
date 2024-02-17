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
        int first = n - 2;
        while (first >= 0 && nums[first] >= nums[first + 1]) {
            first--;
        }
        if (first == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        int second = n - 1;
        while (second > first && nums[second] <= nums[first]) {
            second--;
        }
        swap(nums, second, first);
        reverse(nums, first + 1, n - 1);
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
