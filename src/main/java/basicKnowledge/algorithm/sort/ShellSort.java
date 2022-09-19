package basicKnowledge.algorithm.sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:09
 */
public class ShellSort implements ArraySort {
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
