package knowledge.algorithms.prefixanddiff;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 10:45
 * @description 前缀和 和 差分
 * @see leetcode.problems.LeetCode560
 */
public interface PreSumAndDiff {

    default void preSum(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
    }

    default void suffix(int[] nums) {
        int n = nums.length;
        int[] suffixsum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixsum[i] = suffixsum[i + 1] + nums[i];
        }
    }

}
