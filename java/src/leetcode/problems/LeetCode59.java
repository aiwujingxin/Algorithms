package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 22:24
 */
public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 0;
        int row_start = 0;
        int row_end = matrix.length - 1;
        int col_start = 0;
        int col_end = matrix[0].length - 1;
        while (row_start <= row_end && col_start <= col_end) {
            for (int i = col_start; i <= col_end; i++) {
                matrix[row_start][i] = num;
                num++;
            }
            row_start++;
            for (int i = row_start; i <= row_end; i++) {
                matrix[i][col_end] = num;
                num++;
            }
            col_end--;

            if (row_start <= row_end && col_start <= col_end) {
                for (int i = col_end; i >= col_start; i--) {
                    matrix[row_end][i] = num;
                    num++;
                }
            }
            row_end--;
            if (row_start <= row_end && col_start <= col_end) {
                for (int i = row_end; i >= row_start; i--) {
                    matrix[i][col_start] = num;
                    num++;
                }
            }
            col_start++;
        }
        return matrix;
    }
}
