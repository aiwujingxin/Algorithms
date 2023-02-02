package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/9 21:23
 */
public class LeetCode918 {

    //study
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        dpMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] + nums[i], nums[i]);
            dpMin[i] = Math.min(dpMin[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dpMax[i]);
            min = Math.min(min, dpMin[i]);
            sum += nums[i];
        }
        if (max < 0) {
            return max;
        }
        return Math.max(sum - min, max);
    }
}
