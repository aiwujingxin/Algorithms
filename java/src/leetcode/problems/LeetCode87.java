package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 04:42
 * <a href="https://leetcode.cn/problems/scramble-string/solutions/725484/gong-shui-san-xie-yi-ti-san-jie-di-gui-j-hybk/"></a>
 * @description f[i][j][len] 代表 s1 从 i 开始，s2 从 j 开始，后面长度为 len 的字符是否能形成「扰乱字符串」
 */
public class LeetCode87 {

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


