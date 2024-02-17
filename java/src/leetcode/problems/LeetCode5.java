package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 23:14
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int n = s.length();
        int left = 0;
        int len = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > len) {
                    len = j - i + 1;
                    left = i;
                }
            }
        }
        return s.substring(left, left + len);
    }
}
