package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 23:23
 */
public class LeetCode378_bs {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    //from left bottom or right top we can count how many numbers are equal or less than our target

    public int lessEqual(int[][] matrix, int target) {
        int count = 0;
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] > target) {
                row--;
            } else {
                count = count + row + 1; //?
                col++;
            }
        }
        return count;
    }
}
