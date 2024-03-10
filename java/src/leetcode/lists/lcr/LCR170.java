package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/14 01:34
 */
public class LCR170 {

    int[] temp;
    int cnt = 0;

    public int reversePairs(int[] record) {
        int n = record.length;
        this.temp = new int[n];
        mergeSort(record, 0, n - 1);
        return cnt;
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
                cnt += j - mid - 1;
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            cnt += j - mid - 1;
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
