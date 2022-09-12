package leetcode.hot100;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 23:53
 */
public class LeetCode240_divi {

    //https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/2206538/Java-Divide-and-conquer-solution

    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, 0, matrix.length, 0, matrix[0].length, target);
    }

    private boolean helper(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd, int target) {
        if (rowStart == rowEnd || columnStart == columnEnd) {
            return false;
        }
        int row = rowStart, column = columnStart;
        while (row < rowEnd && column < columnEnd && matrix[row][column] <= target) {
            if (matrix[row][column] == target) {
                return true;
            }
            row++;
            column++;
        }
        // recursively find target in right-top and left-bottom part
        return helper(matrix, rowStart, row, column, columnEnd, target) ||
                helper(matrix, row, rowEnd, columnStart, column, target);
    }
}

