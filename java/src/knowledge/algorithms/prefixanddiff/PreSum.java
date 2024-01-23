package knowledge.algorithms.prefixanddiff;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 10:45
 * @description 前缀和
 * 解决问题：
 * 1.区间求和：通过使用前缀和，可以在常数时间内计算出数组中任意区间的元素之和。
 * 2.子数组和为特定值：在一个给定的数组中，找到和为特定值的子数组。通过计算前缀和，可以将这个问题转化为在前缀和数组中查找两个位置，使得它们之间的元素之和等于特定值。
 * 有时需要将原数组转化成[0,1] 或者[-1,1]后，方便利用前缀和求解满足条件的区间。
 * @see leetcode.problems.LeetCode560
 * @see leetcode.problems.LeetCode974
 * @see leetcode.problems.LeetCode523
 * @see leetcode.problems.LeetCode525
 * @see leetcode.problems.LeetCode2947
 */
public interface PreSum {

    default int[] preSum(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        return presum;
    }

    default int[] suffix(int[] nums) {
        int n = nums.length;
        int[] suffixsum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixsum[i] = suffixsum[i + 1] + nums[i];
        }
        return suffixsum;
    }
}
