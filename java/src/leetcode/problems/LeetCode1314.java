package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 23:06
 * @link <a href=
 * "https://leetcode.com/problems/matrix-block-sum/discuss/1723821/Java-prefixSum">...</a>
 * @see LeetCode304
 * @see LeetCode1292
 */
public class LeetCode1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] presum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                presum[i][j] = mat[i - 1][j - 1] - presum[i - 1][j - 1] + presum[i - 1][j]
                        + presum[i][j - 1];
            }
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int i_min = Math.max(i - k, 0);
                int i_max = Math.min(i + k, m - 1);
                int j_min = Math.max(j - k, 0);
                int j_max = Math.min(j + k, n - 1);
                result[i][j] = presum[i_min][j_min] + presum[i_max + 1][j_max + 1] - presum[i_max + 1][j_min]
                        - presum[i_min][j_max + 1];
            }
        }
        return result;
    }
}
