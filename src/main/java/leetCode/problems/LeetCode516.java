package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-25 2:47 PM
 */
public class LeetCode516 {

    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) return s.length();

        char[] chars = s.toCharArray();

        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < chars.length; ++i) {
            dp[i][i] = 1;
        }

        for (int i = chars.length - 1; i >= 0; --i)
            for (int j = i + 1; j < chars.length; ++j) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }

        return dp[0][chars.length - 1];
    }
}
