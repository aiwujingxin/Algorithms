package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 23:06
 * @link <a href=
 *       "https://leetcode.com/problems/matrix-block-sum/discuss/1723821/Java-prefixSum">...</a>
 * @see LeetCode304
 * @see LeetCode1292
 */
public class LeetCode1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        int[][] prefixSum = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = mat[i - 1][j - 1] - prefixSum[i - 1][j - 1] + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1];
            }
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int i_min = Math.max(i - k, 0);
                int i_max = Math.min(i + k, rows - 1);
                int j_min = Math.max(j - k, 0);
                int j_max = Math.min(j + k, cols - 1);
                result[i][j] = prefixSum[i_min][j_min] + prefixSum[i_max + 1][j_max + 1] - prefixSum[i_max + 1][j_min]
                        - prefixSum[i_min][j_max + 1];
            }
        }
        return result;
    }
}
