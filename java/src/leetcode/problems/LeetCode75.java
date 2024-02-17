package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 21:26
 */
public class LeetCode75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int p0 = 0;
        int p2 = nums.length - 1;
        int index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                swap(nums, p0, index);
                p0++;
                index++;
            } else if (nums[index] == 1) {
                index++;

            } else if (nums[index] == 2) {
                swap(nums, p2, index);
                p2--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
