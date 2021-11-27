package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-24 12:31 上午
 */
public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int j = colStart; j <= colEnd; j++) {
                res.add(matrix[rowStart][j]);
            }
            rowStart++;

            for (int j = rowStart; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                for (int j = rowEnd; j >= rowStart; j--) {
                    res.add(matrix[j][colStart]);
                }
            }
            colStart++;
        }

        return res;
    }
}
