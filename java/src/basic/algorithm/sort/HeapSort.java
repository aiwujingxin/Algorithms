package basic.algorithm.sort;

/**
 * @author jingxinwu
 * @date 2022-02-17 10:21 PM
 */
public class HeapSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        // 从后向前遍历
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
        return nums;
    }

    // 下沉
    private void heapify(int[] nums, int n, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int bigger = i;
        if (l < n && nums[l] > nums[bigger]) {
            bigger = l;
        }
        if (r < n && nums[r] > nums[bigger]) {
            bigger = r;
        }
        if (i != bigger) {
            swap(nums, i, bigger);
            heapify(nums, n, bigger);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
