package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 17:39
 */
public class LeetCode327 {

    long[] arr;

    int count;
    int lower;
    int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        arr = new long[nums.length + 1];
        this.lower = lower;
        this.upper = upper;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (long) nums[i - 1];
        }
        mergeSort(sum, 0, sum.length - 1);
        System.out.println(Arrays.toString(sum));
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
        int low = mid + 1, high = mid + 1;
        int t = left;
        while (t <= mid) {
            while (low <= right && nums[low] - nums[t] < lower) {
                low++;
            }
            while (high <= right && nums[high] - nums[t] <= upper) {
                high++;
            }
            count += high - low;
            t++;
        }

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                arr[k] = nums[i];
                i++;
            } else {
                arr[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = nums[i];
            i++;
            k++;
        }
        while (j <= right) {
            arr[k] = nums[j];
            j++;
            k++;
        }
        for (int n = left; n <= right; n++) {
            nums[n] = arr[n];
        }
    }
}
