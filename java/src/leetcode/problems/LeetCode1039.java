package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/13 22:41
 */
public class LeetCode1039 {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {       // 起点 i 逆序
            for (int j = i + 2; j < n; j++) {    // 终点 j 正序，保证区间长度 >= 3（三角形）
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
