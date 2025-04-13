package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 10:12
 */
public class LeetCode493 {

    int res = 0;
    int[] temp;

    public int reversePairs(int[] nums) {
        this.temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + hi >> 1;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int r = mid + 1;
        for (int l = lo; l <= mid; l++) {
            while (r <= hi && nums[l] > 2 * (long) nums[r]) {
                r++;
            }
            res += r - (mid + 1);
        }
        int k = lo;
        int i = lo;
        int j = mid + 1;
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
