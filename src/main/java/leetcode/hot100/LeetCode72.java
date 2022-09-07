package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:04
 */
public class LeetCode72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }
}
