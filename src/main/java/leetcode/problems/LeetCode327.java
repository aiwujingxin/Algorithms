package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/17 21:35
 */
public class LeetCode327 {

    public static void main(String[] args) {
        System.out.println(new LeetCode327().countRangeSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 10, 15));
        System.out.println(new LeetCode327().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(new LeetCode327().countRangeSum(new int[]{-2, 5, -1, 3, 6, 7, 2, 1, 5, 7}, -2, 5));
    }

    int count = 0;
    int lower;
    int upper;
    long[] temp;

    public int countRangeSum(int[] nums, int lower, int upper) {
        temp = new long[nums.length + 1];
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (long) nums[i - 1];
        }
        this.lower = lower;
        this.upper = upper;
        mergesort(sum, 0, sum.length - 1);
        return count;
    }

    private void mergesort(long[] sum, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(sum, start, mid);
        mergesort(sum, mid + 1, end);
        merge(sum, start, mid, end);
    }

    private void merge(long[] sum, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int k = left;
        int low = mid + 1, high = mid + 1;

        int t = left;
        while (t <= mid) {
            // 计数
            while (low <= right && sum[low] - sum[t] < lower) {
                low++;
            }
            while (high <= right && sum[high] - sum[t] <= upper) {
                high++;
            }
            count += high - low;
            t++;
        }

        while (i <= mid && j <= right) {
            if (sum[i] <= sum[j]) {
                temp[k] = sum[i];
                i++;

            } else {
                temp[k] = sum[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = sum[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = sum[j];
            j++;
            k++;
        }
        for (int n = left; n <= right; n++) {
            sum[n] = temp[n];
        }
    }
}
