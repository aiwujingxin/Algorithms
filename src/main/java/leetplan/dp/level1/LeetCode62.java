package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/19 21:47
 */
public class LeetCode62 {


    public static void main(String[] args) {
        System.out.println(new LeetCode62().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
