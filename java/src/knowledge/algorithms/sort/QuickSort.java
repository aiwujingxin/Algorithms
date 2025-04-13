package knowledge.algorithms.sort;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 22:47
 * @description 快速排序 时间复杂度 O(nlogn)
 */
public class QuickSort implements Sort {

    @Override
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int index = partition(nums, lo, hi);
        quickSort(nums, lo, index - 1);
        quickSort(nums, index + 1, hi);
    }

    public int partition(int[] nums, int i, int j) {
        int ri = new Random().nextInt(j - i + 1) + i;
        swap(nums, i, ri);
        int pi = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pi) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= pi) i++;
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
