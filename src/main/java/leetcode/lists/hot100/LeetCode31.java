package leetcode.lists.hot100;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 23:45
 */
public class LeetCode31 {

    // 5 6 3 4 5 6 7 1 2 3 4 3 2 1
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //从后向前查找，第一个降序的下标
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;   // Now we are finding the breakpoint.
        }
        if (i == -1) {
            Arrays.sort(nums);
            return;
        }
        // 从后向前查找，找到比AX大的数
        if (i >= 0) {  // if that number exists we will just swap it with the next greater number in the right side of the array;
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            //交换
            swap(nums, i, j);
        }
        //反转
        reverse(nums, i + 1, nums.length - 1);  // Now to lower the rank of the permutation we will just reverse the remaining right of the array. And this will also take care of the case when we will not find any breakpoint.
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
