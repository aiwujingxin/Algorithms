package basic.algorithm.sort;

import basic.datastructure.liner.array.ArraySort;
import leetcode.lists.offer.*;
import leetcode.problems.LeetCode315_mergeSort;
import leetcode.problems.LeetCode327;
import leetcode.problems.LeetCode493_mergesort;

/**
 * @author jingxinwu
 * @date 2021-06-06 1:46 下午
 * @see LeetCode315_mergeSort
 * @see LeetCode493_mergesort
 * @see LeetCode327
 * @see Offer51
 */

/*
0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
归并排序就是先把左半边数组排好序，再把右半边数组排好序，然后把两半数组合并.
要对子数组 a[1o..hi] 进行排序，先将它分为 a[1o..mid] 和 a[mid+1..hi] 两部分，分别通过
递归调用将它们单独排序，最后将有序的子数组归并为最终的排序结果。
l       m         r
8       11       15
n1 = m - l + 1 = 4
n2 = r - m = 4
L[i] = arr[l + i]
R[j] = arr[m + 1 + j]
* */
public class MergeSort implements ArraySort {

    int[] arr;

    @Override
    public int[] sortArray(int[] nums) {
        arr = new int[nums.length];
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
                arr[k] = nums[i];
                i++;
            } else {
                arr[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = nums[i];
            i++;
            k++;
        }
        while (j <= right) {
            arr[k] = nums[j];
            j++;
            k++;
        }
        if (right + 1 - left >= 0) System.arraycopy(arr, left, nums, left, right + 1 - left);
    }
}
