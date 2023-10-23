package leetcode.problems;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-08-13 1:02 上午
 */
public class LeetCode189 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, -100, 3, 99};
        rotate(nums1, 2);
        System.out.println(Arrays.toString(nums1));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
