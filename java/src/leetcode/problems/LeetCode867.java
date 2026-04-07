package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 4/6/26 20:30
 */
public class LeetCode867 {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] transposed = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
