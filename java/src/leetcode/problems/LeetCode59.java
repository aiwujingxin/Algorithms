package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 16:37
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{};
        }
        int[][] res = new int[n][n];
        int row_start = 0;
        int row_end = n - 1;
        int col_start = 0;
        int col_end = n - 1;
        int index = 1;
        while (row_start <= row_end && col_start <= col_end) {
            for (int i = col_start; i <= col_end; i++) {
                res[row_start][i] = index;
                index++;
            }
            row_start++;
            for (int i = row_start; i <= row_end; i++) {
                res[i][col_end] = index;
                index++;
            }
            col_end--;

            for (int i = col_end; i >= col_start; i--) {
                res[row_end][i] = index;
                index++;
            }
            row_end--;

            for (int i = row_end; i >= row_start; i--) {
                res[i][col_start] = index;
                index++;
            }
            col_start++;
        }

        return res;
    }
}
