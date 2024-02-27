package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/27 17:02
 */
public class LeetCode1981 {

    public int minimizeTheDifference(int[][] mat, int target) {
        // f[i][j]表示前i行中可以能得到总和为j的布尔类型
        int n = mat.length, m = mat[0].length;
        boolean[][] f = new boolean[n + 1][4901];
        f[0][0] = true;
        int ans = Integer.MAX_VALUE;
        int preSum = 0;
        for (int i = 1; i <= n; i++) {
            int maxV = mat[i - 1][0];
            for (int j = 0; j < m; j++) {
                for (int k = mat[i - 1][j]; k <= mat[i - 1][j] + preSum; k++) {
                    f[i][k] |= f[i - 1][k - mat[i - 1][j]];
                }
                maxV = Math.max(maxV, mat[i - 1][j]);
            }
            preSum += maxV;
        }

        for (int i = 0; i <= 4900; i++) {
            if (f[n][i]) {
                ans = Math.min(ans, Math.abs(i - target));
            }
        }

        return ans;
    }
}
