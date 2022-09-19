package basicKnowledge.algorithm.sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 22:47
 */
public class QuickSort implements ArraySort {
    @Override
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }


    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (right > left && nums[right] > pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
