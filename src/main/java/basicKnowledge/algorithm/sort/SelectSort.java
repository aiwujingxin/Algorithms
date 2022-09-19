package basicKnowledge.algorithm.sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:14
 */
public class SelectSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // One by one lmove boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = nums[min_idx];
            nums[min_idx] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
