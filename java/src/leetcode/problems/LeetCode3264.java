package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/5/25 15:25
 */
public class LeetCode3264 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = nums[0];
            int idx = 0;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }
            nums[idx] *= multiplier;
        }
        return nums;
    }
}
