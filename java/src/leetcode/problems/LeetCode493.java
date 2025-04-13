package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 10:12
 */
public class LeetCode493 {

    int[] t;
    int count;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        this.t = new int[n];
        mergeSort(nums, 0, n - 1);
        return count;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + hi >> 1;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] a, int l, int m, int r) {
        int right = m + 1;
        for (int left = l; left <= m; left++) {
            while (right <= r && a[left] > 2 * (long) a[right]) {
                right++;
            }
            count += right - (m + 1);
        }
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = t[i];
    }
}
