package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/13 11:56
 * <a href="https://leetcode.cn/problems/regular-expression-matching/solution/c-hui-su-fa-dfsji-yi-hua-by-randy_waler-ws8t/">...</a>
 */


public class LeetCode10_dfs {

    public boolean isMatch(String s, String p) {
        return dfs(s, 0, p, 0);
    }

    public boolean dfs(String s, int si, String p, int pi) {
        if (si == s.length()) {
            return pi == p.length() ||
                    (pi + 1 < p.length() && p.charAt(pi + 1) == '*' && dfs(s, si, p, pi + 2));
        } else if (pi == p.length()) {
            return false;
        }
        if (s.charAt(si) == p.charAt(pi) || (p.charAt(pi) == '.')) {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                return dfs(s, si + 1, p, pi) || dfs(s, si + 1, p, pi + 2) || dfs(s, si, p, pi + 2);
            } else {
                return dfs(s, si + 1, p, pi + 1);
            }
        } else {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                return dfs(s, si, p, pi + 2);
            }
        }
        return false;
    }
}
