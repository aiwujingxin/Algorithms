package basic.algorithm.sort;

import basic.problems.array.ArraySort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:14
 */
public class SelectSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) minIdx = j;
            }
            swap(nums, minIdx, i);
        }
        return nums;
    }

    private void swap(int[] nums, int minIdx, int i) {
        int temp = nums[minIdx];
        nums[minIdx] = nums[i];
        nums[i] = temp;
    }
}
