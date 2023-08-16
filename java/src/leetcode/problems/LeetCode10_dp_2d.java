package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 23:03
 */
public class LeetCode10_dp_2d {

    //https://leetcode.com/problems/regular-expression-matching/discuss/2335781/JavaC%2B%2BPythonJavaScriptKotlin3LINES-O(n)timeBEATS-99.97-MEMORYSPEED-0ms-APRIL-2022

    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) return (s == null || s.length() == 0);

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
            }
        }
        return dp[s.length()][p.length()];
    }
}
