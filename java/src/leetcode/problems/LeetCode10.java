package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 11:46
 */
public class LeetCode10 {

    public boolean isMatch(String ss, String pp) {
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int m = s.length;
        int n = p.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n && p[j - 1] == '*'; j += 2) {
            dp[0][j] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2] || (s[i - 1] == p[j - 2] || p[j - 2] == '.') && dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    class Solution_OPT {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            // 只需要两行即可，利用 i % 2 进行滚动交替
            boolean[][] dp = new boolean[2][n + 1];
            dp[0][0] = true;
            // 初始化
            for (int j = 2; j <= n && p.charAt(j - 1) == '*'; j += 2) {
                dp[0][j] = dp[0][j - 2];
            }
            for (int i = 1; i <= m; i++) {
                int curr = i % 2;
                int prev = (i - 1) % 2;
                // 每次进入新的一行，第0列必须重置为 false (非空字符串无法匹配空模式串)
                dp[curr][0] = false;
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[curr][j] = dp[prev][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[curr][j] = dp[curr][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[prev][j]);
                    } else {
                        dp[curr][j] = false;
                    }
                }
            }
            return dp[m % 2][n];
        }
    }
}
