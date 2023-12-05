package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 22:44
 */
public class LeetCode1140 {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sum = new int[n];
        sum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] memo = new int[n][n];
        return dfs(piles, 0, 1, memo, sum);
    }

    private int dfs(int[] piles, int index, int M, int[][] memo, int[] sum) {
        if (index == piles.length) {
            return 0;
        }
        if (piles.length - index <= 2 * M) {
            return sum[index];
        }
        if (memo[index][M] != 0) {
            return memo[index][M];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * M; i++) {
            // 限制对手的值到最小
            min = Math.min(min, dfs(piles, index + i, Math.max(M, i), memo, sum));
        }
        // 减去对手的值 得到本轮自己得到的最大值
        return memo[index][M] = sum[index] - min;
    }
}
