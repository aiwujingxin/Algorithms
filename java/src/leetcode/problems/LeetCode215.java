package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/28 10:27
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest(int[] nums, int lo, int hi, int k) {
        if (lo > hi) {
            return -1;
        }
        int index = partition(nums, lo, hi);
        if (index + 1 == k) {
            return nums[index];
        }
        if (index + 1 > k) {
            return findKthLargest(nums, lo, index - 1, k);
        }
        return findKthLargest(nums, index + 1, hi, k);
    }

    public int partition(int[] nums, int i, int j) {
        int ri = new Random().nextInt(j - i + 1) + i;
        swap(nums, i, ri);
        int pi = nums[i];
        while (i < j) {
            while (i < j && nums[j] <= pi) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] >= pi) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
