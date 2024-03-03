package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 00:54
 */
public class LeetCode526_dp {

    public int countArrangement(int n) {
        int mask = 1 << n;
        int[][] dp = new int[n + 1][mask];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 枚举所有的状态
            for (int state = 0; state < mask; state++) {
                // 枚举位置 i（最后一位）选的数值是 k
                for (int k = 1; k <= n; k++) {
                    // 首先 k 在 state 中必须是 1
                    if (((state >> (k - 1)) & 1) == 0) continue;
                    // 数值 k 和位置 i 之间满足任一整除关系
                    if (k % i != 0 && i % k != 0) continue;
                    // state & (~(1 << (k - 1))) 代表将 state 中数值 k 的位置置零
                    dp[i][state] += dp[i - 1][state & (~(1 << (k - 1)))];
                }
            }
        }
        return dp[n][mask - 1];
    }
}
