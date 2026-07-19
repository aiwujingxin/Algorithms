package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 6/15/26 22:09
 */
public class LeetCode3877 {

    int n;
    int target;
    int[] nums;
    Map<String, Integer> memo = new HashMap<>();

    public int minRemovals(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.n = nums.length;
        int maxKeep = dfs(0, 0);
        if (maxKeep == Integer.MIN_VALUE) return -1;
        return n - maxKeep;
    }

    private int dfs(int idx, int curXor) {
        if (idx == n) {
            // 到最后了，如果异或值等于 target，则保留 0 个（不保留元素了）
            return curXor == target ? 0 : Integer.MIN_VALUE;
        }

        String key = idx + "#" + curXor;
        if (memo.containsKey(key)) return memo.get(key);

        // 不选 nums[idx]
        int noTake = dfs(idx + 1, curXor);

        // 选 nums[idx]
        int take = dfs(idx + 1, curXor ^ nums[idx]);
        if (take != Integer.MIN_VALUE) take += 1;  // 保留当前元素

        int best = Math.max(noTake, take);
        memo.put(key, best);
        return best;
    }

    public int minRemovals_dp(int[] nums, int target) {
        int n = nums.length;

        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        int m = 32 - Integer.numberOfLeadingZeros(mx); // mx 的二进制长度
        if ((1 << m) <= target) {
            return -1;
        }

        // dp[i][xor] = 考虑前 i 个数，异或值为 xor 时，最多能保留的元素个数
        int[][] dp = new int[n + 1][1 << m];

        // 初始化：不可能的状态设为 -∞
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0; // 前0个数，异或值为0，保留0个元素

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int xor = 0; xor < (1 << m); xor++) {
                // 不选第 i 个数
                dp[i][xor] = dp[i - 1][xor];

                // 选第 i 个数（需要从上一个状态转移过来）
                int prevXor = xor ^ num;
                if (dp[i - 1][prevXor] != Integer.MIN_VALUE) {
                    dp[i][xor] = Math.max(dp[i][xor], dp[i - 1][prevXor] + 1);
                }
            }
        }

        int maxKeep = dp[n][target];
        return maxKeep == Integer.MIN_VALUE ? -1 : n - maxKeep;
    }
}

