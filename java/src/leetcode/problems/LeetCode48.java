package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 21:40
 */
public class LeetCode48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {           //控制旋转的圈数（由外向内）。
            for (int j = i; j < n - 1 - i; j++) {   //控制每一圈中待交换元素的个数。从当前层的左上角顶点开始。
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = t;
            }
        }
    }
}
