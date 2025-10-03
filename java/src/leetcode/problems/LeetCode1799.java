package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 16:00
 */
public class LeetCode1799 {

    public int maxScore(int[] nums) {
        int m = nums.length; // m = 2 * n
        int maxMask = 1 << m;
        // dp[mask]: 使用 mask 集合中的数字进行配对能获得的最大分数
        int[] dp = new int[maxMask];
        // 预计算所有数对的 gcd，避免重复计算
        int[][] gcdMatrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                gcdMatrix[i][j] = gcd(nums[i], nums[j]);
            }
        }
        // 遍历所有状态 mask
        for (int mask = 1; mask < maxMask; mask++) {
            int k = Integer.bitCount(mask);
            // 如果 mask 中 1 的个数是奇数，则不是一个合法的中间状态，跳过
            if (k % 2 != 0) {
                continue;
            }
            // 当前是第 (k / 2) 次操作
            int opIndex = k / 2;
            // 遍历所有可能的数对 (i, j) in mask
            for (int i = 0; i < m; i++) {
                // 如果 nums[i] 不在 mask 中，跳过
                if ((mask & (1 << i)) == 0) continue;
                for (int j = i + 1; j < m; j++) {
                    // 如果 nums[j] 不在 mask 中，跳过
                    if ((mask & (1 << j)) == 0) continue;
                    // 找到了 mask 中的一对 (i, j)
                    // 计算上一个状态的 mask
                    int prevMask = mask ^ (1 << i) ^ (1 << j);
                    // 状态转移
                    int currentScore = opIndex * gcdMatrix[i][j];
                    dp[mask] = Math.max(dp[mask], dp[prevMask] + currentScore);
                }
            }
        }
        return dp[maxMask - 1];
    }

    // 辅助函数：计算最大公约数
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
