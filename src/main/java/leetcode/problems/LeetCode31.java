package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-06-18 12:50 上午
 */
public class LeetCode31 {

    // 1 2 3 8 5 2
    // 1 2 5 8 3 2

    /*
     * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
     * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
     * 这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     *
     * 满足「较小数」尽量靠右，而「较大数」尽可能小。
     * */

    public static void main(String[] args) {
        LeetCode31 leetCode31 = new LeetCode31();
        int[] arr = new int[]{1, 2, 3};
        leetCode31.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i == -1) {
            Arrays.sort(nums);
            return;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        reverse(nums, i + 1);
        return;
    }

    private void reverse(int[] nums, int index) {
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
