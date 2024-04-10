package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 11:46
 * @link <a href="https://www.youtube.com/watch?v=qWxLyexGW1k"></a>
 */
public class LeetCode10 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // init s空串的情况
        for (int j = 2; j <= n; j += 2) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*')
                    // 0个 || 多个
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
            }
        }
        return dp[m][n];
    }
}
