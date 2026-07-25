package knowledge.algorithms.sort.comparison;

import knowledge.algorithms.sort.Sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 插入排序 每个元素插入到已排序部分的正确位置来逐步构建有序序列的简单排序算法
 */
public class InsertSort implements Sort {

    @Override
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
        return nums;
    }
}
