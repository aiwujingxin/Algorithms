package knowledge.algorithms.sort.comparison;

import knowledge.algorithms.sort.Sort;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
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

    /**
     * 三路快排：适合大量重复元素，把区间划分为 < pivot | == pivot | > pivot 三段。
     * 等于 pivot 的部分直接就位不再递归，重复多时从 O(n^2) 退化风险中解放。
     */
    public void quickSort3Way(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int ri = new Random().nextInt(hi - lo + 1) + lo;
        swap(nums, lo, ri);
        int pivot = nums[lo];
        int lt = lo, gt = hi, i = lo + 1;
        while (i <= gt) {
            if (nums[i] < pivot) swap(nums, lt++, i++);
            else if (nums[i] > pivot) swap(nums, i, gt--);
            else i++;
        }
        quickSort3Way(nums, lo, lt - 1);
        quickSort3Way(nums, gt + 1, hi);
    }
}
