package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 15:05
 */
public class LeetCode996 {


    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // 1. 对数组排序，这是为了后续处理重复数字
        Arrays.sort(nums);

        // 2. 预处理邻接关系
        // adj[i][j] = true 表示 nums[i] 和 nums[j] 可以相邻
        boolean[][] adj = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPerfectSquare(nums[i] + nums[j])) {
                    adj[i][j] = true;
                }
            }
        }

        // 3. 定义 DP 状态
        // dp[mask][i]：已用数字集合为 mask，且最后一个数字是 nums[i] 的排列数
        int[][] dp = new int[1 << n][n];

        // 4. 初始化 DP
        // 对于只包含一个元素的排列
        for (int i = 0; i < n; i++) {
            // 去重：如果当前数字和前一个相同，但前一个没被选，则跳过
            // 这是为了保证相同数字的选取顺序
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            dp[1 << i][i] = 1;
        }

        // 5. 状态转移
        for (int mask = 1; mask < (1 << n); mask++) {       // 阶段
            for (int i = 0; i < n; i++) {                   // 状态 遍历当前 mask 的最后一位 i
                // 如果 nums[i] 在 mask 集合中
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < n; j++) {           // 遍历上一个状态的最后一位 j
                        // 如果 nums[j] 在 mask 集合中，且 j != i
                        // 并且 nums[i] 和 nums[j] 可以相邻
                        if (j != i && (mask & (1 << j)) != 0 && adj[i][j]) {
                            // 找到上一个状态的 mask
                            int prevMask = mask ^ (1 << i);
                            // 去重逻辑：
                            // 如果 nums[i] 是重复数字中的一个，
                            // 并且它的前一个相同数字 nums[i-1] 在 prevMask 中没有被使用，
                            // 那么当前这种从 j -> i 的转移路径是不合法的，因为它破坏了相同数字的选取顺序。
                            // 我们必须先选 nums[i-1] 再选 nums[i]。
                            if (i > 0 && nums[i] == nums[i - 1] && (prevMask & (1 << (i - 1))) == 0) {
                                continue;
                            }
                            dp[mask][i] += dp[prevMask][j];
                        }
                    }
                }
            }
        }

        // 6. 计算最终结果
        // 累加所有数字都用完时的所有情况
        int totalCount = 0;
        int finalMask = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            totalCount += dp[finalMask][i];
        }

        return totalCount;
    }

    // 检查一个数是否是完全平方数
    private boolean isPerfectSquare(int n) {
        if (n < 0) return false;
        if (n == 0) return true;
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
