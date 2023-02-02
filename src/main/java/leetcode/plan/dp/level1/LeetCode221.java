package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/20 21:41
 */
public class LeetCode221 {

    public static void main(String[] args) {
        System.out.println(new LeetCode221().
                maximalSquare(new char[][]{
                        {'1', '0', '1', '1', '0', '1'},
                        {'1', '1', '1', '1', '1', '1'},
                        {'0', '1', '1', '0', '1', '1'},
                        {'1', '1', '1', '0', '1', '0'},
                        {'0', '1', '1', '1', '1', '1'},
                        {'1', '1', '0', '1', '1', '1'}}));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        int a = Integer.MIN_VALUE;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
                a = Math.max(a, dp[i][j]);
            }
        }
        return a * a;
    }
}
