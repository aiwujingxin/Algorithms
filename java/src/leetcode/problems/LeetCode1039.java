package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/13 22:41
 */
public class LeetCode1039 {

    private int[] values;
    private Integer[][] memo;

    public int minScoreTriangulation(int[] values) {
        this.values = values;
        int n = values.length;
        memo = new Integer[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int l, int r) {
        if (l + 1 == r) {// base 只有两个点，无法组成三角形
            return 0;
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        int res = Integer.MAX_VALUE;
        for (int k = l + 1; k < r; ++k) { // 枚举顶点 k
            res = Math.min(res, dfs(l, k) + dfs(k, r) + values[l] * values[r] * values[k]);
        }
        return memo[l][r] = res;
    }


    public int minScoreTriangulation_dp(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 3; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + values[l] * values[r] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int minScoreTriangulation_len(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {       // 起点 i 逆序
            for (int j = i + 2; j < n; j++) {    // 终点 j 正序，保证区间长度 >= 3（三角形）
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][n - 1];
    }
}
