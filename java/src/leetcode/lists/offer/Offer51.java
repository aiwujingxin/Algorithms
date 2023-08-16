package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-12-04 5:29 下午
 */
public class Offer51 {

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
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                arr[k] = nums[i];
                i++;
            } else {
                arr[k] = nums[j];
                j++;
                count += mid - i + 1; // 统计逆序对
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
