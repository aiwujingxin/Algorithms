package basic.algorithm.sort;

import basic.datastructure.liner.array.ArraySort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:14
 * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到第二个元素位置。
 * 以此类推，直到所有元素均排序完毕。
 */
public class SelectSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[minIdx] > nums[j]) {
                    minIdx = j;
                }
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
