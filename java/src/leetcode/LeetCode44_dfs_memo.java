package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 20:42
 */
public class LeetCode44_dfs_memo {

    //https://leetcode.com/problems/wildcard-matching/discuss/477823/Recursive-DFS-solution-with-memoization-(Top-Down-Approach)

    Integer[][] dp;

    public boolean isMatch(String s, String p) {

        dp = new Integer[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = 1;

        for (int i = p.length() - 1; i >= 0; --i) {
            dp[s.length()][i] = p.charAt(i) == '*' ? dp[s.length()][i + 1] : 0;
        }

        for (int j = 0; j < s.length(); ++j) {
            dp[j][p.length()] = 0;
        }

        dfsHelper(s, p, 0, 0);
        return dp[0][0] == 1;

    }

    private int dfsHelper(String s, String p, int sp, int pp) {

        if (dp[sp][pp] != null) {
            return dp[sp][pp];
        }

        if (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?') {
            dp[sp][pp] = dfsHelper(s, p, sp + 1, pp + 1);
        } else if (p.charAt(pp) == '*') {

            int resultOne = dfsHelper(s, p, sp + 1, pp); // matching seq with *
            int resultTwo = dfsHelper(s, p, sp, pp + 1); // matching * with empty string
            int resultThree = dfsHelper(s, p, sp + 1, pp + 1); // end matching seq with * and inc both

            dp[sp][pp] = (resultOne + resultTwo + resultThree) > 0 ? 1 : 0;

        } else {
            dp[sp][pp] = 0;
        }

        return dp[sp][pp];
    }
}
