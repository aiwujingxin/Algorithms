package leetcode.lists.hot200;


/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/6 21:20
 */
public class LeetCode161 {

    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        return dfs(s, 0, t, 0, false);
    }

    public boolean dfs(String s, int sIndex, String t, int tIndex, boolean isEdit) {

        if (sIndex == s.length()) {
            return tIndex == t.length() || (!isEdit && Math.abs(tIndex - t.length()) == 1);
        }

        if (tIndex == t.length()) {
            return (!isEdit && Math.abs(sIndex - s.length()) == 1);
        }

        if (s.charAt(sIndex) != t.charAt(tIndex)) {
            if (isEdit) {
                return false;
            }
            return dfs(s, sIndex + 1, t, tIndex, true) ||
                    dfs(s, sIndex, t, tIndex + 1, true) ||
                    dfs(s, sIndex + 1, t, tIndex + 1, true);
        } else {
            return dfs(s, sIndex + 1, t, tIndex + 1, isEdit);
        }
    }


    public boolean isOneEditDistance_opt(String s, String t) {
        if (s.length() > t.length()) {
            return isOneEditDistance_opt(t, s);
        }
        int n = s.length(), m = t.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (n == m) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return n + 1 == m;
    }
}
