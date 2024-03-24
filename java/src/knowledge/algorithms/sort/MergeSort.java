package knowledge.algorithms.sort;

import leetcode.problems.LeetCode315;
import leetcode.problems.LeetCode327;
import leetcode.problems.LeetCode493;

/**
 * @author jingxinwu
 * @date 2021-06-06 1:46 下午
 * @description 归并排序
 * @see leetcode.lists.lcr.LCR170
 * @see LeetCode315
 * @see LeetCode493
 * @see LeetCode327
 */

public class MergeSort implements Sort {

    int[] temp;

    @Override
    public int[] sortArray(int[] nums) {
        this.temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int k = lo;
        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= hi) {
            temp[k++] = nums[j++];
        }
        for (int x = lo; x <= hi; x++) {
            nums[x] = temp[x];
        }
    }
}
