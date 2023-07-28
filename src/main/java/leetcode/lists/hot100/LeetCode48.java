package leetcode.lists.hot100;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 23:27
 */
public class LeetCode48 {

    public static void main(String[] args) {
        int[][] arrs = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new LeetCode48().rotate(arrs);
        System.out.println(Arrays.deepToString(arrs));
    }

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return;
        }

        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
