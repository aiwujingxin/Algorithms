package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-16 7:02 PM
 */
public class LeetCode48 {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int l = 0;
        int r = matrix.length - 1;
        while (l < r) {
            int[] temp = matrix[l];
            matrix[l] = matrix[r];
            matrix[r] = temp;
            l++;
            r--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
    }

}
