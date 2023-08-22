package basicKnowledge.algorithm.sort;

import basicKnowledge.dataStructure.array.ArraySort;

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
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
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
            int temp = nums[i];
            nums[i] = nums[bigger];
            nums[bigger] = temp;
            heapify(nums, n, bigger);
        }
    }

}
