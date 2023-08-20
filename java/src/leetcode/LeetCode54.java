package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-24 12:31 上午
 */
public class LeetCode54 {
    public static void main(String[] args) {
        System.out.println(new LeetCode54().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

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
            rowStart++; //删掉一行

            for (int j = rowStart; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--; //删掉一列

            //[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
            //必须要有row和col的时候才可以遍历
            if (rowStart <= rowEnd) {// col还有，但是row没有了：rowStart++ 改变了row

                for (int j = colEnd; j >= colStart; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            //[[7],[9],[6]]
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
