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
 * @see LeetCode5
 * @see LeetCode647
 * @see LeetCode214
 * @see LeetCode132
 */
public class Manacher {

    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length * 2 + 1;
        char[] t = new char[n];
        for (int i = 0; i < chs.length; i++) {
            t[i * 2] = '#';
            t[i * 2 + 1] = chs[i];
        }
        t[n - 1] = '#';
        int[] d = new int[n];
        int c = 0, r = 0, maxLen = 0, maxCenter = 0;
        for (int i = 0; i < n; i++) {
            // 加速盒子
            d[i] = r > i ? Math.min(d[2 * c - i], r - i) : 0;
            // 中心扩展
            while (i - d[i] - 1 >= 0 && i + d[i] + 1 < n &&
                    t[i - d[i] - 1] == t[i + d[i] + 1]) {
                d[i]++;
            }
            // 更新最右边界
            if (i + d[i] > r) {
                c = i;
                r = i + d[i];
            }
            // 更新全局最优解
            if (d[i] > maxLen) {
                maxCenter = i;
                maxLen = d[i];
            }
        }
        int start = (maxCenter - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
