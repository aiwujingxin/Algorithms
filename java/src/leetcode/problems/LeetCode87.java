package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 04:42
 * @description f[i][j][len] 代表 s1 从 i 开始，s2 从 j 开始，后面长度为 len 的字符是否能形成「扰乱字符串」
 */
public class LeetCode87 {

    Boolean[][][] memo;

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        memo = new Boolean[n][n][n + 1];
        return isScramble(s1, s2, 0, 0, n);
    }

    private boolean isScramble(String s1, String s2, int i, int j, int len) {
        if (len == 1) return s1.charAt(i) == s2.charAt(j);
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) return true;
        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }
        // 字符频次剪枝 如果两个子串包含的字符种类不同，绝对不可能是扰乱字符串
        int[] count = new int[26];
        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }
        for (int k = 0; k < 26; k++) {
            if (count[k] != 0) {
                memo[i][j][len] = false;
                return false;
            }
        }
        boolean res = false;
        for (int k = 1; k < len; k++) {
            res = isScramble(s1, s2, i, j, k) && isScramble(s1, s2, i + k, j + k, len - k) || isScramble(s1, s2, i, j + len - k, k) && isScramble(s1, s2, i + k, j, len - k);
            if (res) break;
        }
        memo[i][j][len] = res;
        return res;
    }

    class Solution_DP_Table {

        public boolean isScramble(String s1, String s2) {
            if (s1.equals(s2)) return true;
            if (s1.length() != s2.length()) return false;
            int n = s1.length();
            char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
            boolean[][][] f = new boolean[n][n][n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[i][j][1] = cs1[i] == cs2[j];
                }
            }
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    for (int j = 0; j <= n - len; j++) {
                        for (int k = 1; k < len; k++) {
                            // (s1前==s2前) && (s1后==s2后) ||  (s1前==s2后) && (s1后==s2前)
                            if (f[i][j][k] && f[i + k][j + k][len - k] || f[i][j + len - k][k] && f[i + k][j][len - k]) {
                                f[i][j][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
            return f[0][0][n];
        }
    }
}


