package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 22:12
 */
public class LeetCode75 {
    public void sortColors(int[] nums) {
        int point0 = 0; // p0的左边全都是0
        int point2 = nums.length - 1;  // p2的右边全都是2
        int i = 0; // 工作指针

        while (i <= point2) {
            if (nums[i] == 0) {
                swap(nums, point0, i);
                i++;
                point0++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, point2, i);
                point2--;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
