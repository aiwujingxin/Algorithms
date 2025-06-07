package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:35
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, len = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > len) {
                    start = i;
                    len = j - i + 1;
                }
            }
        }
        return s.substring(start, start + len);
    }

    // 斜着遍历
    public String longestPalindrome_len(String s) {
        int n = s.length(), start = 0, maxLen = 0;
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen) {
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
