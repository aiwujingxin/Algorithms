package leetcode.problems;

import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 8/14/25 01:16
 * @description 注意初始化条件
 */
public class LeetCode2915 {

    public int lengthOfLongestSubsequence_1d(List<Integer> nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int num : nums) {
            // 倒序遍历，保证每个数只用一次（0-1背包）
            for (int s = target; s >= num; s--) {
                if (dp[s - num] != -1) {
                    dp[s] = Math.max(dp[s], dp[s - num] + 1);
                }
            }
        }
        return dp[target];
    }

    public int lengthOfLongestSubsequence_2d(List<Integer> nums, int target) {
        int n = nums.size();
        // dp[i][s] = 考虑前 i 个数，和为 s 时，最多能选多少个数
        int[][] dp = new int[n + 1][target + 1];
        // 初始化：不可达状态设为 -1
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;  // 前0个数，和为0，选0个数
        for (int i = 1; i <= n; i++) {
            int num = nums.get(i - 1);
            for (int s = 0; s <= target; s++) {
                // 不选当前数
                dp[i][s] = dp[i - 1][s];
                // 选当前数
                if (s >= num && dp[i - 1][s - num] != -1) {
                    dp[i][s] = Math.max(dp[i][s], dp[i - 1][s - num] + 1);
                }
            }
        }
        return dp[n][target];
    }
}
