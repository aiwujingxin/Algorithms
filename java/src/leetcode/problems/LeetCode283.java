package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 01:11
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        int p0 = 0;
        while (index < n) {
            while (index < n && nums[index] == 0) {
                index++;
            }
            if (index == n) {
                return;
            }
            swap(nums, p0, index);
            p0++;
            index = p0;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
