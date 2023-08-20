package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/17 21:11
 */
public class LeetCode493_mergesort {

    int count;

    int[] arr;

    public int reversePairs(int[] nums) {
        arr = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int k = left;

        int l = left, r = mid + 1;
        while (l <= mid) {
            while (r <= right && nums[l] > 2L * (long) nums[r]) {
                r++;
            }
            count += r - mid - 1;
            l++;
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
        if (right + 1 - left >= 0) System.arraycopy(arr, left, nums, left, right + 1 - left);
    }
}
