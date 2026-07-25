package knowledge.mathematics.probability.impl;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 快速选择 (期望 O(n) 求第 k 小)
 * <适用场景>
 * 无序数组求第 k 小 / 第 k 大、Top-K、中位数，不需要整体排序。
 * <核心思想>
 * 借用快排的 partition：一次划分把基准放到最终位置 p，
 * 若 p==k 则命中；否则只递归 k 所在的一侧，期望线性。随机基准规避有序退化。
 */
public class QuickSelect {

    private static final Random RANDOM = new Random();

    /**
     * 返回数组中第 k 小的元素（k 从 0 计数）。会原地打乱 nums。
     */
    public static int select(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k) return nums[pivotIndex];
            if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, right);
        int pivot = nums[right];
        int store = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, store++, i);
            }
        }
        swap(nums, store, right);
        return store;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
