package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 22:48
 */
public class LeetCode75 {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int index = 0;
        while (index <= p2) { // 不能漏
            if (nums[index] == 0) {
                swap(nums, index, p0);
                p0++;
                index++; // 可以++
            } else if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, p2);
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
