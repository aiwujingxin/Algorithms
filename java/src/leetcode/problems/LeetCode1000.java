package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/11 21:59
 */
public class LeetCode1000 {

    private Integer[][][] memo;
    private int[] presum;
    private int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) {
            // 无法合并成一堆
            return -1;
        }
        this.presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + stones[i - 1];
        }
        this.k = k;
        this.memo = new Integer[n][n][k + 1];
        return dfs(0, n - 1, 1);
    }

    private int dfs(int i, int j, int p) {
        if (memo[i][j][p] != null) {
            return memo[i][j][p];
        }
        if (p == 1) { // 合并成一堆
            return memo[i][j][p] = i == j ? 0 : dfs(i, j, k) + presum[j + 1] - presum[i];
        }
        int res = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {
            res = Math.min(res, dfs(i, m, 1) + dfs(m + 1, j, p - 1));
        }
        return memo[i][j][p] = res;
    }
}
