package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:11
 */

public class LeetCode85_dp {

    public static void main(String[] args) {
        System.out.println(new LeetCode85_dp().maximalRectangle(new char[][]{{}, {}, {}, {}}));
    }

    //https://leetcode.com/problems/maximal-rectangle/discuss/403093/Java-Simple-DP-Solution-with-state-table
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    dp[i][j] = matrix[i][j] == '1' ? (dp[i - 1][j] + 1) : 0;
                }
                int min = dp[i][j];
                for (int k = j; k >= 0; k--) {
                    if (min == 0) {
                        break;
                    }
                    if (dp[i][k] < min) {
                        min = dp[i][k];
                    }
                    maxArea = Math.max(maxArea, min * (j - k + 1));
                }
            }
        }
        return maxArea;
    }
}
