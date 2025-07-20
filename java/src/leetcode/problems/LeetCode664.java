package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/6/25 13:19
 * @description 分类讨论方式
 * 默认加一 + 合并
 * 区间分割枚举 k
 * 从左端首字符分类
 */
public class LeetCode664 {

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
