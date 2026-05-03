package knowledge.datastructure.string.manacher;

import leetcode.problems.LeetCode132;
import leetcode.problems.LeetCode214;
import leetcode.problems.LeetCode5;
import leetcode.problems.LeetCode647;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/04/05 18:53
 * @description 用于在 O(n)的时间复杂度内找到字符串的最长回文子串。
 * 核心思想: 利用已经找到的回文串的“对称性”，来跳过不必要的重复计算。
 * 摊还分析: 每个字符最多被成功匹配一次，最多被失败匹配一次, 从而将时间复杂度严丝合缝地锁死在了 O(N)。
 * @see LeetCode5
 * @see LeetCode647
 * @see LeetCode214
 * @see LeetCode132
 */
public class Manacher {

    public String longestPalindrome(String s) {
        int n = s.length() * 2 + 1;
        char[] chs = new char[n];
        for (int i = 0; i < s.length(); i++) {
            chs[i * 2] = '#';
            chs[i * 2 + 1] = s.charAt(i);
        }
        chs[n - 1] = '#';
        int[] d = new int[n];
        int center = 0, right = 0;
        int ansCenter = 0, ansLen = 0;
        for (int i = 0; i < n; i++) {
            d[i] = i < right ? Math.min(d[2 * center - i], right - i) : 0;
            while (i - d[i] - 1 >= 0 && i + d[i] + 1 < n && chs[i - d[i] - 1] == chs[i + d[i] + 1]) {
                d[i]++;
            }
            if (i + d[i] > right) {
                center = i;
                right = i + d[i];
            }
            if (d[i] > ansLen) {
                ansCenter = i;
                ansLen = d[i];
            }
        }
        int start = (ansCenter - ansLen) / 2;
        return s.substring(start, start + ansLen);
    }
}
