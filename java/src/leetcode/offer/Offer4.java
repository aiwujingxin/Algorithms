package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 13:19
 */
public class Offer4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
