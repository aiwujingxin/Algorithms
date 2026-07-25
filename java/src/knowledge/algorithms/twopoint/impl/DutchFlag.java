package knowledge.algorithms.twopoint.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 荷兰国旗三路划分 (Dutch National Flag)
 * <适用场景>
 * 只含三类元素（0/1/2 或 小于/等于/大于基准）的原地分区，一趟 O(n) 完成。
 * <核心>
 * 维护三段边界：[0,lt) 为 0，[lt,i) 为 1，(gt,n-1] 为 2。
 * i 遇 0 与 lt 交换并双进；遇 2 与 gt 交换、gt 左移但 i 不动（换来的元素待判）；遇 1 只前进。
 * @see knowledge.algorithms.sort.comparison.QuickSort 大量重复元素时用三路划分防退化
 */
public class DutchFlag {

    /**
     * 将只含 0/1/2 的数组原地排序（LeetCode 75 颜色分类）。
     */
    public void sortColors(int[] nums) {
        int lt = 0, i = 0, gt = nums.length - 1;
        while (i <= gt) {
            if (nums[i] < 1) {
                swap(nums, i++, lt++);
            } else if (nums[i] > 1) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
