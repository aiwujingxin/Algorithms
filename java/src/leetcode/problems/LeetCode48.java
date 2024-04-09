package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 21:40
 */
public class LeetCode48 {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] t = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = t;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
