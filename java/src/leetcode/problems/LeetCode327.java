package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 17:39
 */
public class LeetCode327 {

    long[] temp;

    int count;
    int lower;
    int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] presum = new long[nums.length + 1];
        int n = nums.length;
        temp = new long[n + 1];
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

    private void merge(long[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int k = lo;

        int l = mid + 1, r = mid + 1;
        int t = lo;
        while (t <= mid) {
            while (l <= hi && nums[l] - nums[t] < lower) {
                l++;
            }
            while (r <= hi && nums[r] - nums[t] <= upper) {
                r++;
            }
            count += r - l;
            t++;
        }

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
