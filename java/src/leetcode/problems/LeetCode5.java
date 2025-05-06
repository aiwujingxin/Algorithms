package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:35
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        int n = s.length(), left = 0, right = 0, len = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > len) {
                    left = i;
                    right = j;
                    len = j - i + 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
