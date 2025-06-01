package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 04:42
 * <a href="https://leetcode.cn/problems/scramble-string/solutions/725484/gong-shui-san-xie-yi-ti-san-jie-di-gui-j-hybk/"></a>
 */
public class LeetCode87 {

    String s1;
    String s2;
    int n;
    Boolean[][][] memo;

    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.n = s1.length();
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        memo = new Boolean[n][n][n + 1];
        return dfs(0, 0, n);
    }

    boolean dfs(int i, int j, int len) {
        if (memo[i][j][len] != null) return memo[i][j][len];
        String a = s1.substring(i, i + len), b = s2.substring(j, j + len);
        if (a.equals(b)) {
            return memo[i][j][len] = true;
        }
        if (!check(a, b)) {
            return memo[i][j][len] = true;
        }
        for (int k = 1; k < len; k++) {
            // (s1前 vs s2前) && (s1后 vs s2后) ||  (s1前 vs s2后) && (s1后 vs s2前)
            if (dfs(i, j, k) && dfs(i + k, j + k, len - k) || dfs(i, j + len - k, k) && dfs(i + k, j, len - k)) {
                return memo[i][j][len] = true;
            }
        }
        memo[i][j][len] = false;
        return false;
    }

    // 检查 s1 和 s2 词频是否相同
    boolean check(String a, String b) {
        int[] cnt = new int[26];
        for (int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i) - 'a']++;
            cnt[b.charAt(i) - 'a']--;
        }
        for (int c : cnt) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}


