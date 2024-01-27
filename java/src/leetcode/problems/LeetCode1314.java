package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 18:52
 */
public class LeetCode1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] matrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] + mat[i - 1][j - 1] - matrix[i - 1][j - 1];
            }
        }

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                answer[i][j] = matrix[r2 + 1][c2 + 1] - matrix[r2 + 1][c1] - matrix[r1][c2 + 1] + matrix[r1][c1];
            }
        }
        return answer;
    }
}
