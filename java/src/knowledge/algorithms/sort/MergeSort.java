package knowledge.algorithms.sort;

import leetcode.problems.*;
import leetcode.lists.lcr.*;

/**
 * @author jingxinwu
 * @date 2021-06-06 1:46 下午
 * @description 归并排序
 * @see LCR170
 * @see LeetCode315
 * @see LeetCode327
 * @see LeetCode493
 */

public class MergeSort implements Sort {

    int[] t;

    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        this.t = new int[n];
        sort(nums, 0, n - 1);
        return nums;
    }

    void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        sort(a, l, m);
        sort(a, m + 1, r);
        merge(a, l, m, r);
    }

    void merge(int[] a, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = t[i];
    }
}
