package basic.algorithm.sort;

import basic.structure.array.*;

/**
 * @author jingxinwu
 * @date 2021-06-06 4:59 下午
 */
public class BubbleSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        //最大的元素沉到列表的最后一个位置
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}

