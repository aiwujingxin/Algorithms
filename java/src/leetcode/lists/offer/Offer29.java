package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 22:04
 */
public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        int index = 0;
        int[] res = new int[m * n];
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= down; i++) {
                res[index++] = matrix[i][right];
            }
            right--;
            if (top <= down && left <= right) {
                for (int i = right; i >= left; i--) {
                    res[index++] = matrix[down][i];
                }
                down--;
            }
            if (top <= down && left <= right) {
                for (int i = down; i >= top; i--) {
                    res[index++] = matrix[i][left];
                }
                left++;
            }
        }
        return res;
    }
}
