package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 10:16
 */
public class LCR96 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() +s2.length() != s3.length()) {
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j + 1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = s3.charAt(i + j + 1) == s1.charAt(i) && dp[i][j + 1] || s3.charAt(i + j + 1) == s2.charAt(j) && dp[i + 1][j];
            }
        }
        return dp[n][m];
    }
}
