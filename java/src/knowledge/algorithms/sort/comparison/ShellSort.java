package knowledge.algorithms.sort.comparison;

import knowledge.algorithms.sort.Sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 希尔排序
 */
public class ShellSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        for (int dk = nums.length / 2; dk >= 1; dk /= 2) {
            for (int i = dk; i < nums.length; i++) {
                int j = i - dk;
                int temp = nums[i];
                while (j >= 0 && nums[j] > temp) {
                    nums[j + dk] = nums[j];
                    j = j - dk;
                }
                nums[j + dk] = temp;
            }
        }
        return nums;
    }
}
