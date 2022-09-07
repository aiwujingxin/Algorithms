package leetcode.study.recursive;

import java.util.Random;

/**
 * @author jingxinwu
 * @date 2022-01-31 2:17 PM
 */
public class QuickSort {

    /**
     * 随机化是为了防止递归树偏斜的操作，此处不展开叙述
     */
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    /**
     * 对数组的子区间 nums[left..right] 排序
     *
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right) {
        // 1. 递归终止条件
        if (left >= right) {
            return;
        }

        int pIndex = partition(nums, left, right);

        // 2. 拆分，对应「分而治之」算法的「分」
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);

        // 3. 递归完成以后没有「合」的操作，这是由「快速排序」partition 的逻辑决定的
    }

    /**
     * 将数组 nums[left..right] 分区，返回下标 pivot，
     * 且满足 [left + 1..lt) <= pivot，(gt, right] >= pivot
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;

        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }

            // 细节：相等的元素通过交换，等概率分到数组的两边
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
