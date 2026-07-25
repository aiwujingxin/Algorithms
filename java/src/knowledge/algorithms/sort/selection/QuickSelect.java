package knowledge.algorithms.sort.selection;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 快速选择 时间复杂度 O(n)
 * @see leetcode.problems.LeetCode215
 * @see leetcode.problems.LeetCode324
 * @see leetcode.problems.LeetCode347
 * @see leetcode.problems.LeetCode414
 * @see leetcode.problems.LeetCode462
 */
public class QuickSelect implements TopK {

    @Override
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {
        int index = partition(nums, lo, hi);
        if (index + 1 == k) return nums[index];
        return index + 1 > k ? quickSelect(nums, lo, index - 1, k) : quickSelect(nums, index + 1, hi, k);
    }

    private int partition(int[] nums, int i, int j) {
        swap(nums, i, new Random().nextInt(j - i + 1) + i);
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

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
