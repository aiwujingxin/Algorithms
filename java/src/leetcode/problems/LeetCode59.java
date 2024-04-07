package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 16:37
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{};
        }
        int[][] res = new int[n][n];
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int index = 1;
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res[top][i] = index;
                index++;
            }
            top++;
            for (int i = top; i <= down; i++) {
                res[i][right] = index;
                index++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[down][i] = index;
                index++;
            }
            down--;
            for (int i = down; i >= top; i--) {
                res[i][left] = index;
                index++;
            }
            left++;
        }
        return res;
    }
}
