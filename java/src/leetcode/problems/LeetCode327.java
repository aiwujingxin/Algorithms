package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 17:39
 */
public class LeetCode327 {

    long[] t;
    int count;
    int lower;
    int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] presum = new long[n + 1];
        this.t = new long[n + 1];
        this.lower = lower;
        this.upper = upper;
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + (long) nums[i - 1];
        }
        mergeSort(presum, 0, presum.length - 1);
        return count;
    }

    private void mergeSort(long[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(long[] a, int l, int m, int r) {
        int r1 = m + 1, r2 = m + 1;
        for (int left = l; left <= m; left++) {
            while (r1 <= r && a[r1] - a[left] < lower) {
                r1++;
            }
            while (r2 <= r && a[r2] - a[left] <= upper) {
                r2++;
            }
            count += r2 - r1;
        }
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = t[i];
    }
}
