package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 4/6/26 20:35
 */
public class LeetCode1572 {

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            if (i != n - i - 1) {
                sum += mat[i][n - 1 - i];
            }
        }
        return sum;
    }
}
