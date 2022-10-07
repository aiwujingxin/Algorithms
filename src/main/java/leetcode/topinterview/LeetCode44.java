package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 02:23
 */
public class LeetCode44 {

    // study half
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0) == 1;
    }

    int dfs(String s, String p, int si, int pi) {
        if (si == s.length() && pi == p.length()) {
            return 1;
        }
        if (pi == p.length()) {
            return 0;
        }
        if (si == s.length()) {
            int i = 0;
            while (pi + i < p.length()) {
                if (p.charAt(pi + i++) != '*') {
                    return -1;
                }
            }
            return 1;
        }

        if ((p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
            return dfs(s, p, si + 1, pi + 1);
        } else if (p.charAt(pi) == '*') {
            for (int i = 0; i + si <= s.length(); i++) {
                int ans = dfs(s, p, si + i, pi + 1);
                if (ans != 0) {
                    return ans;
                }
            }
        }
        return 0;
    }
}
