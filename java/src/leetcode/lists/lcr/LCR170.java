package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/14 01:34
 */
public class LCR170 {

    int[] t;
    int count;

    public int reversePairs(int[] record) {
        int n = record.length;
        this.t = new int[n];
        mergeSort(record, 0, n - 1);
        return count;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int m = l + r >> 1;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    public void merge(int[] nums, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                count += j - m - 1;
                t[k++] = nums[i++];
            } else {
                t[k++] = nums[j++];
            }
        }
        while (i <= m) {
            count += j - m - 1;
            t[k++] = nums[i++];
        }
        while (j <= r) t[k++] = nums[j++];
        for (i = l; i <= r; i++) nums[i] = t[i];
    }
}
