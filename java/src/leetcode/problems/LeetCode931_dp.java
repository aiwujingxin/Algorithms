package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-16 1:22 AM
 */
public class LeetCode931_dp {

    public static void main(String[] args) {
//        System.out.println(new LeetCode931().minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(new LeetCode931_dp().minFallingPathSum(new int[][]{{-48}}));
    }

    public int minFallingPathSum(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        //init
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, matrix[0].length);
        /*
         * 2,1,3
         * 6,5,4
         * 7,8,9
         * */
        /*
         * 0 2,1,3 0  lastRow
         * 0 6,5,4 0 j
         * 0 7,8,9 0
         * */

        //0 7 6 5 0
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < dp.length; j++) {
            for (int k = 0; k < dp[0].length; k++) {
                if (k == 0) {
                    dp[j][k] = Math.min(dp[j - 1][k], dp[j - 1][k + 1]) + matrix[j][k];
                } else if (k == dp[0].length - 1) {
                    dp[j][k] = Math.min(dp[j - 1][k], dp[j - 1][k - 1]) + matrix[j][k];
                } else {
                    dp[j][k] = Math.min(dp[j - 1][k], Math.min(dp[j - 1][k - 1], dp[j - 1][k + 1])) + matrix[j][k];
                }
            }
        }
        for (int j = 0; j < dp[0].length; j++) {
            min = Math.min(dp[dp.length - 1][j], min);
        }
        return min;
    }
}
