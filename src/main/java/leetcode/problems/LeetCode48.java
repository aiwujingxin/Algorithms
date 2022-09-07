package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-06-23 11:25 下午
 */
public class LeetCode48 {


    /*
0,0  0,1 0, 2
11  9  1   5
10  8  4    2 1,3
7   6  3  13 2,3
16 12  14 15 3,3
    *
    *
    * */


    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        //行
        int row = matrix.length - 1;
        //列
        int col = matrix[0].length - 1;
        //左右反转
        for (int i = 0; i < col / 2; i++) {
            for (int j = 0; j < row; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][col - i];
                matrix[j][col - i] = temp;
            }
        }

        //斜对角线折叠
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (i + j == row) {
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[col - j][row - i];
                matrix[col - j][row - i] = temp;
            }
        }
    }
}
