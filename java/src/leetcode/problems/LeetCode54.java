package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 16:08
 */
public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int row_start = 0;
        int row_end = matrix.length - 1;
        int col_start = 0;
        int col_end = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (row_start <= row_end && col_start <= col_end) {

            for (int i = col_start; i <= col_end; i++) {
                res.add(matrix[row_start][i]);
            }

            row_start++;
            for (int i = row_start; i <= row_end; i++) {
                res.add(matrix[i][col_end]);
            }
            col_end--;

            if (row_start <= row_end && col_start <= col_end) {
                for (int i = col_end; i >= col_start; i--) {
                    res.add(matrix[row_end][i]);
                }
            }
            row_end--;
            if (row_start <= row_end && col_start <= col_end) {
                for (int i = row_end; i >= row_start; i--) {
                    res.add(matrix[i][col_start]);
                }
            }
            col_start++;
        }
        return res;
    }
}
