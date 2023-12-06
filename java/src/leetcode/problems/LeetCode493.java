package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 13:50
 */
public class LeetCode493 {

    int res = 0;
    int[] nums;
    int[] temp;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        this.nums = nums;
        this.temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return res;
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

        // 统计
        int l = left, r = mid + 1;
        while (l <= mid) {
            while (r <= right && nums[l] > 2L * (long) nums[r]) {
                r++;
            }
            res += r - mid - 1;
            l++;
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
