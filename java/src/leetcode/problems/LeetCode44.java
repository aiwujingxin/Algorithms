package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 20:43
 */
public class LeetCode44 {

    //https://leetcode.com/problems/wildcard-matching/discuss/1662953/DFS-without-memo
    Boolean[][] memo; // 0 indicates haven't found, -1 is not possible, 1 is possible!

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    boolean dfs(String s, String p, int si, int pi) {
        if (memo[si][pi] != null) {
            return memo[si][pi];
        }
        if (si == s.length() && pi == p.length()) {
            memo[si][pi] = true;
            return true;
        }
        //当p走到最后，说明匹配失败
        if (pi == p.length()) {
            memo[si][pi] = false;
            return false;
        }
        //当s走到最后，判断p剩下的是否都是*
        if (si == s.length()) {
            int i = 0;
            while (pi + i < p.length()) {
                if (p.charAt(pi + i++) != '*') {
                    memo[si][pi] = false;
                    return false;
                }
            }
            memo[si][pi] = true;
            return true;
        }

        if ((p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
            return dfs(s, p, si + 1, pi + 1);
        }
        if (p.charAt(pi) == '*') {
            //case * 的话， 可以向后匹配很多的字符
            for (int i = 0; i + si <= s.length(); i++) {
                boolean ans = dfs(s, p, si + i, pi + 1);
                if (ans) {
                    memo[si][pi] = true;
                    return true;
                }
            }
        }
        memo[si][pi] = false;
        return false;
    }
}
