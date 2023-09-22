package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/17 17:17
 */
public class LeetCode516_v2 {


    public int longestPalindromeSubseq(String s) {
        String strResver = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= strResver.length(); j++) {
                if (s.charAt(i - 1) == strResver.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s.length()][strResver.length()];
    }
}
