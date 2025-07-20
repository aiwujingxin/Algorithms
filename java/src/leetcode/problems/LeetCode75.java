package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 22:48
 */
public class LeetCode75 {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        while (i <= p2) { // 不能越界
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++; // index才可以++
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
