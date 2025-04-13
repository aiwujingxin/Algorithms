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

    public void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                count += j - mid - 1;
                t[k++] = nums[i++];
            } else {
                t[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            count += j - mid - 1;
            t[k++] = nums[i++];
        }
        while (j <= hi) {
            t[k++] = nums[j++];
        }
        for (int x = lo; x <= hi; x++) {
            nums[x] = t[x];
        }
    }
}
