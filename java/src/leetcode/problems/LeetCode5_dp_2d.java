package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 11:44
 */
public class LeetCode5_dp_2d {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res) {
                    res = j - i + 1;
                    left = i;
                    right = j + 1;
                }
            }
        }
        return s.substring(left, right);
    }
}
