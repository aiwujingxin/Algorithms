package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 14:48
 */
public class LeetCode698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        // 1. 预处理和剪枝
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int target = sum / k;
        // 排序优化：从大到小排序，便于剪枝
        Arrays.sort(nums);
        if (nums[n - 1] > target) return false;
        // 检查是否有数字大于 target
        for (int num : nums) {
            if (num > target) return false;
        }
        int m = 1 << n;
        boolean[] dp = new boolean[m];
        int[] currentSum = new int[m];
        // 2. 初始化
        dp[0] = true;
        // 3. 状态转移
        // 对状态进行排序，优先处理较小的状态
        for (int state = 0; state < m; state++) {
            if (!dp[state]) continue;
            for (int i = 0; i < n; i++) {
                if ((state & (1 << i)) != 0) continue; // 数字已使用
                int nextState = state | (1 << i);
                int newSum = currentSum[state] + nums[i];
                // 剪枝：如果新状态已经处理过且有效，跳过
                if (dp[nextState]) continue;
                if (newSum <= target) {
                    currentSum[nextState] = newSum % target;
                    dp[nextState] = true;
                    // 提前返回：如果找到最终状态，直接返回
                    if (nextState == m - 1) {
                        return true;
                    }
                }
            }
        }
        return dp[m - 1];
    }
}
