package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 00:21
 */
public class LeetCode931 {

    public static void main(String[] args) {
//        System.out.println(new LeetCode931().minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(new LeetCode931().minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));
    }

    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 2];


        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i - 1][j - 1];
                } else if (j + 1 == dp[0].length - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]) + matrix[i - 1][j - 1];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < dp[dp.length - 1].length - 1; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }
}
