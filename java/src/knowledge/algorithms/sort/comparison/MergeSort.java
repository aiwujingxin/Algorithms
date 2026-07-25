package knowledge.algorithms.sort.comparison;

import knowledge.algorithms.sort.Sort;
import leetcode.lists.lcr.LCR170;
import leetcode.problems.LeetCode315;
import leetcode.problems.LeetCode327;
import leetcode.problems.LeetCode493;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
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

    void sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int m = l + r >> 1;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    void merge(int[] a, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = t[i];
    }

    /**
     * 归并求逆序对：统计 i<j 且 a[i]>a[j] 的对数（会排序原数组）。
     * 合并阶段左段元素大于右段当前元素时，左段剩余元素都与之构成逆序对，一次性累加。
     */
    public long countInversions(int[] nums) {
        this.t = new int[nums.length];
        return sortCount(nums, 0, nums.length - 1);
    }

    private long sortCount(int[] a, int l, int r) {
        if (l >= r) return 0;
        int m = l + r >> 1;
        long count = sortCount(a, l, m) + sortCount(a, m + 1, r);
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) {
                t[k++] = a[i++];
            } else {
                count += m - i + 1;
                t[k++] = a[j++];
            }
        }
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = t[i];
        return count;
    }
}
