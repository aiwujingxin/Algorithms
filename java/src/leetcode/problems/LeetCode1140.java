package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 22:44
 */
public class LeetCode1140 {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] presum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            presum[i] = presum[i + 1] + piles[i];
        }
        int[][] memo = new int[n][n];
        return dfs(n, 0, 1, memo, presum);
    }

    private int dfs(int n, int index, int M, int[][] memo, int[] sum) {
        if (index == n) {
            return 0;
        }
        if (n - index <= 2 * M) {
            return sum[index];
        }
        if (memo[index][M] != 0) {
            return memo[index][M];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * M; i++) {
            // 限制对手的值到最小
            min = Math.min(min, dfs(n, index + i, Math.max(M, i), memo, sum));
        }
        // 减去对手的值 得到本轮自己得到的最大值
        return memo[index][M] = sum[index] - min;
    }
}
