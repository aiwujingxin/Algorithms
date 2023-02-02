package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 01:42
 */
public class LeetCode240_bs {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int low = 0;
            int high = matrix[0].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (ints[mid] < target) {
                    low = mid + 1;
                } else if (target < ints[mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
