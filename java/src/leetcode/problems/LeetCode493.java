package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 13:50
 */
public class LeetCode493 {

    int res = 0;
    int[] temp;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        this.temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int k = lo;
        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                int index = leftBound(nums, lo, mid, (long) 2 * nums[j]);
                res += mid - index + 1;
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
        while (j <= hi) {
            int index = leftBound(nums, lo, mid, (long) 2 * nums[j]);
            res += mid - index + 1;
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (int n = lo; n <= hi; n++) {
            nums[n] = temp[n];
        }
    }

    int leftBound(int[] nums, int start, int end, long target) {
        int left = start;
        int right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] <= target) {
            return left + 1;
        }
        return left;
    }
}
