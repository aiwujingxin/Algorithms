package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 22:04
 */
public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        int index = 0;
        int[] res = new int[m * n];
        while (top <= down && left <= right) {
            int col_start = left;
            while (col_start <= right) {
                res[index++] = matrix[top][col_start];
                col_start++;
            }
            top++;
            int row_start = top;
            while (row_start <= down) {
                res[index++] = matrix[row_start][right];
                row_start++;
            }
            right--;
            int col_end = right;
            if (top <= down && left <= right) {
                while (left <= col_end) {
                    res[index++] = matrix[down][col_end];
                    col_end--;
                }
                down--;
            }
            if (top <= down && left <= right) {
                int row_end = down;
                while (top <= row_end) {
                    res[index++] = matrix[row_end][left];
                    row_end--;
                }
                left++;
            }
        }
        return res;
    }
}
