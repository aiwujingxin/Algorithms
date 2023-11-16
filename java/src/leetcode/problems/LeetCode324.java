package leetcode.problems;

import basic.algorithm.sort.QuickSelect;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 00:48
 * @link <a href="https://leetcode.com/problems/wiggle-sort-ii/solutions/77680/clear-java-o-n-avg-time-o-n-space-solution-using-3-way-partition/">...</a>
 */
public class LeetCode324 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int x = (n + 1) / 2;
        int mid = x - 1;
        int target = new QuickSelect().findKthLargest(nums, n - mid);
        for (int k = 0, i = 0, j = n - 1; k <= j; k++) {
            if (nums[k] > target) {
                while (j > k && nums[j] > target) {
                    j--;
                }
                swap(nums, k, j--);
            }
            if (nums[k] < target) {
                swap(nums, k, i++);
            }
        }
        int[] arr = nums.clone();
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
