package knowledge.algorithms.sort;

import java.util.Random;

import leetcode.problems.*;


/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 21:08
 * @description 快速选择
 * @see LeetCode215
 * @see LeetCode324
 * @see LeetCode347
 * @see LeetCode414
 * @see LeetCode462
 */

public class QuickSelect implements TopK {

    @Override
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int lo, int hi, int k) {
        if (lo > hi) return -1;
        int index = partition(nums, lo, hi);
        int rank = index + 1;
        if (rank == k) return nums[index];
        if (rank > k) return quickSelect(nums, lo, index - 1, k);
        return quickSelect(nums, index + 1, hi, k);
    }

    private int partition(int[] nums, int i, int j) {
        int rand = new Random().nextInt(j - i + 1) + i;
        swap(nums, rand, i);
        int pi = nums[i];
        while (i < j) {
            while (i < j && nums[j] <= pi) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] >= pi) i++;
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }

    private void swap(int[] nums, int rand, int i) {
        int t = nums[rand];
        nums[rand] = nums[i];
        nums[i] = t;
    }
}
