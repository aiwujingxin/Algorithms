package knowledge.algorithms.sort;

/**
 * @author jingxinwu
 * @date 2021-06-06 4:59 下午
 * @description 冒泡排序 每一趟遍历，将一个最大的数移到序列末尾。
 */
public class BubbleSort implements Sort {

    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}


