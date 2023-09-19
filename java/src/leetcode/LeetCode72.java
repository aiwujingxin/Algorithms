package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/19 22:20
 */
public class LeetCode72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[m + 1][n + 1];
        // 边界状态初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int add = dp[i - 1][j] + 1;
                int replace = dp[i][j - 1] + 1;
                int delete = dp[i - 1][j - 1] + (word1.charAt(i - 1) != word2.charAt(j - 1) ? 1 : 0);
                dp[i][j] = Math.min(Math.min(add, replace), delete);
            }
        }
        return dp[m][n];
    }
}
