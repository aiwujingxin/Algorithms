package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 02:23
 */
public class LeetCode54 {

    public static void main(String[] args) {
        System.out.println(new LeetCode54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new LeetCode54().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int row_start = 0;
        int row_end = matrix.length - 1;
        int col_start = 0;
        int col_end = matrix[0].length - 1;

        List<Integer> list = new ArrayList<>();
        //fix  "<="
        while (row_start <= row_end && col_start <= col_end) {

            //fix  "<="
            for (int i = col_start; i <= col_end; i++) {
                list.add(matrix[row_start][i]);
            }
            row_start++;

            for (int i = row_start; i <= row_end; i++) {
                list.add(matrix[i][col_end]);
            }

            col_end--;


            if (row_start <= row_end) {//fix
                for (int i = col_end; i >= col_start; i--) {
                    list.add(matrix[row_end][i]);
                }
            }
            row_end--;

            if (col_start <= col_end) {//fix

                for (int i = row_end; i >= row_start; i--) {
                    list.add(matrix[i][col_start]);
                }
            }
            col_start++;
        }
        return list;
    }
}
