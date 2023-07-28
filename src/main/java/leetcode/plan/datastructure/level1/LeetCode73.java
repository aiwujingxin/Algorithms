package leetcode.plan.datastructure.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/9 21:50
 */
public class LeetCode73 {

    public void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return;
        }
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
