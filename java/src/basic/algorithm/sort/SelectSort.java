package basic.algorithm.sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:14
 * @description 分为排好的和未排好顺序的. 在未排序序列中找到最小元素，存放到排序序列的当前位置
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
