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
        long[] sum = new long[nums.length + 1];
        temp = new long[nums.length + 1];
        this.lower = lower;
        this.upper = upper;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (long) nums[i - 1];
        }
        mergeSort(sum, 0, sum.length - 1);
        return count;
    }

    private void mergeSort(long[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(long[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int k = left;

        // 计数
        int l = mid + 1, r = mid + 1;
        int t = left;
        while (t <= mid) {
            while (l <= right && nums[l] - nums[t] < lower) {
                l++;
            }
            while (r <= right && nums[r] - nums[t] <= upper) {
                r++;
            }
            count += r - l;
            t++;
        }

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
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
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (int n = left; n <= right; n++) {
            nums[n] = temp[n];
        }
    }
}
