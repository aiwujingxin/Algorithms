package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/11 21:59
 */
public class LeetCode1000 {

    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                // 判断区间 [i..j] 是否可以最终合并为一堆
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += pre[j + 1] - pre[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
