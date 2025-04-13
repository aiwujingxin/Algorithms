package knowledge.algorithms.sort;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 21:08
 * @description 快速选择 时间复杂度 O(n)
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
        int index = new QuickSort().partition(nums, lo, hi);
        int rank = index + 1;
        if (rank == k) return nums[index];
        if (rank > k) return quickSelect(nums, lo, index - 1, k);
        return quickSelect(nums, index + 1, hi, k);
    }
}
