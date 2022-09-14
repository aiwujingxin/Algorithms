package basicKnowledge.algorithm.sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:14
 */
public class SelectSort implements Sort {

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            int temp = nums[index];
            for (int j = index; j < nums.length; j++) {
                if (nums[j] < temp) {
                    index = j;
                }
            }
            int n = nums[index];
            nums[i] = nums[index];
            nums[index] = n;
        }
    }
}
