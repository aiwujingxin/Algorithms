package basicKnowledge.algorithm.sort;

/**
 * @author jingxinwu
 * @date 2021-06-06 4:59 下午
 */
public class BubbleSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}


