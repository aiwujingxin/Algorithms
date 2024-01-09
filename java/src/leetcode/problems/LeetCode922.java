package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 22:26
 */
public class LeetCode922 {

    public int[] sortArrayByParityII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int even = 0;
        int odd = 1;
        while (odd < n && even < n) {
            if (nums[n - 1] % 2 == 0) {
                swap(nums, even, n - 1);
                even += 2;
            } else {
                swap(nums, odd, n - 1);
                odd += 2;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
