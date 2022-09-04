package leetCode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 21:07
 */
public class LeetCode10_dfs {

    //https://www.youtube.com/watch?v=7M-dShnqqEI

    //https://leetcode.com/problems/regular-expression-matching/discuss/2200029/JAVA-or-Recursion-with-memoization-or-Beats-100
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return find(s, p, 0, 0, memo);
    }

    private boolean find(String s, String p, int i, int j, Boolean[][] memo) {

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i >= s.length() || j >= p.length()) {
            // p没了, s 还在
            if (i < s.length()) {
                return false;
            }

            // s没了 , p 还在
            for (; j < p.length(); j++) {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    continue;
                }
                if (p.charAt(j) != '*') {
                    return false;
                }
            }
            return true;
        }

        boolean isMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';

        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            if (isMatch) {
                memo[i][j] = find(s, p, i + 1, j, memo) || find(s, p, i, j + 2, memo);
            } else {
                memo[i][j] = find(s, p, i, j + 2, memo);
            }
        } else {
            if (isMatch) {
                memo[i][j] = find(s, p, i + 1, j + 1, memo);
            } else {
                memo[i][j] = false;
            }
        }
        return memo[i][j];
    }
}
