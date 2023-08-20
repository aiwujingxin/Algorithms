package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 20:43
 */
public class LeetCode44_dfs {

    //https://leetcode.com/problems/wildcard-matching/discuss/1662953/DFS-without-memo
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0) == 1;
    }

    int dfs(String s, String p, int si, int pi) {
        if (si == s.length() && pi == p.length()) {
            return 1;
        }
        //当p走到最后，说明匹配成功
        if (pi == p.length()) {
            return 0;
        }
        //当s走到最后，判断p剩下的是否都是*
        if (si == s.length()) {
            int i = 0;
            while (pi + i < p.length()) {
                if (p.charAt(pi + i++) != '*') {
                    return -1;
                }
            }
            return 1;
        }

        // case ?
        if ((p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
            return dfs(s, p, si + 1, pi + 1);


        } else if (p.charAt(pi) == '*') {
            //case * 的话， 可以向后匹配很多的字符
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
