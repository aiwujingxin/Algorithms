package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 11:46
 * <a href="https://leetcode.cn/problems/regular-expression-matching/solution/c-hui-su-fa-dfsji-yi-hua-by-randy_waler-ws8t/">...</a>
 */
public class LeetCode10 {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    public boolean dfs(String s, String p, int si, int pi) {
        if (memo[si][pi] != null) {
            return memo[si][pi];
        }
        boolean possible;
        if (si == s.length()) {
            possible = pi == p.length() || (pi + 1 < p.length() && p.charAt(pi + 1) == '*' && dfs(s, p, si, pi + 2));
            memo[si][pi] = possible;
            return possible;
        }
        if (pi == p.length()) {
            memo[si][pi] = false;
            return false;
        }
        boolean flag = pi + 1 < p.length() && p.charAt(pi + 1) == '*';
        if (s.charAt(si) == p.charAt(pi) || (p.charAt(pi) == '.')) {
            if (flag) {
                possible = dfs(s, p, si + 1, pi) || dfs(s, p, si + 1, pi + 2) || dfs(s, p, si, pi + 2);
                memo[si][pi] = possible;
                return possible;
            }

            possible = dfs(s, p, si + 1, pi + 1);
            memo[si][pi] = possible;
            return possible;
        } else {
            if (flag) {
                possible = dfs(s, p, si, pi + 2);
                memo[si][pi] = possible;
                return possible;
            }
        }
        return false;
    }


    //https://leetcode.com/problems/regular-expression-matching/discuss/2335781/JavaC%2B%2BPythonJavaScriptKotlin3LINES-O(n)timeBEATS-99.97-MEMORYSPEED-0ms-APRIL-2022
    public boolean isMatch_dp(String s, String p) {
        if (p == null || p.isEmpty() || s == null || s.isEmpty()) {
            return true;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
            }
        }
        return dp[s.length()][p.length()];
    }
}
