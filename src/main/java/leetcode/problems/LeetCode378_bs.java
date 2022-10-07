package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 23:23
 */
public class LeetCode378_bs {


    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/2367160/JAVA-oror-Easy-Solution-oror-100-faster-code.
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
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
