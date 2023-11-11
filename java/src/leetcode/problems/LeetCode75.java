package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 21:17
 */
public class LeetCode75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int p0 = 0;
        int p2 = nums.length - 1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                swap(nums, index, p0);
                index++;
                p0++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
