package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-06-25 12:16 上午
 */
public class LeetCode63 {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        //初始化
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        //行
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        //列
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }
}
