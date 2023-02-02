package basic.algorithm.sort;

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
            //从后向前找比基准小的数
            while (right > left && nums[right] > pivot) {
                right--;
            }
            //把比基准小的数移到低端
            nums[left] = nums[right];

            //从前向后找比基准大的数
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            //把比基准大的数移到高端
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
