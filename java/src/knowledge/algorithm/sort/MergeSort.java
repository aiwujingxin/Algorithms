package knowledge.algorithm.sort;

import leetcode.problems.LeetCode315;
import leetcode.problems.LeetCode327;
import leetcode.problems.LeetCode493;

/**
 * @author jingxinwu
 * @date 2021-06-06 1:46 下午
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

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (int n = left; n <= right; n++) {
            nums[n] = temp[n];
        }
    }
}
