package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 10/3/24 16:01
 */
public class LeetCode466 {

    // 本方法时间复杂度O(s1长度 * s2长度)，一定是最优解
    public static int getMaxRepetitions(String str1, int a, String str2, int b) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n = s1.length;
        // next[i][j] : 从i位置出发，至少需要多少长度，能找到j字符
        int[][] next = new int[n][26];
        // 时间复杂度O(s1长度 + s2长度)
        if (!find(s1, n, next, s2)) {
            return 0;
        }
        // st[i][p] : 从i位置出发，至少需要多少长度，可以获得2^p个s2
        long[][] st = new long[n][30];
        // 时间复杂度O(s1长度 * s2长度)
        for (int i = 0, cur, len; i < n; i++) {
            cur = i;
            len = 0;
            for (char c : s2) {
                len += next[cur][c - 'a'];
                cur = (cur + next[cur][c - 'a']) % n;
            }
            st[i][0] = len;
        }
        // 时间复杂度O(s1长度)
        for (int p = 1; p <= 29; p++) {
            for (int i = 0; i < n; i++) {
                st[i][p] = st[i][p - 1] + st[(int) ((st[i][p - 1] + i) % n)][p - 1];
            }
        }
        long ans = 0;
        // 时间复杂度O(1)
        for (int p = 29, start = 0; p >= 0; p--) {
            if (st[start % n][p] + start <= (long) n * a) {
                ans += 1L << p;
                start += (int) st[start % n][p];
            }
        }
        return (int) (ans / b);
    }

    // 时间复杂度O(s1长度 + s2长度)
    public static boolean find(char[] s1, int n, int[][] next, char[] s2) {
        int[] right = new int[26];
        Arrays.fill(right, -1);
        for (int i = n - 1; i >= 0; i--) {
            right[s1[i] - 'a'] = i + n;
        }
        for (int i = n - 1; i >= 0; i--) {
            right[s1[i] - 'a'] = i;
            for (int j = 0; j < 26; j++) {
                if (right[j] != -1) {
                    next[i][j] = right[j] - i + 1;
                } else {
                    next[i][j] = -1;
                }
            }
        }
        for (char c : s2) {
            if (next[0][c - 'a'] == -1) {
                return false;
            }
        }
        return true;
    }
}
