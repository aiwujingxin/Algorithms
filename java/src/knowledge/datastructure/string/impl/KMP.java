package knowledge.datastructure.string.impl;

import knowledge.datastructure.string.Search;
import leetcode.problems.LeetCode1392;
import leetcode.problems.LeetCode1764_kmp;
import leetcode.problems.LeetCode214;
import leetcode.problems.LeetCode28;

/**
 * @author aiwujingxin@gmail.com
 * @date 2024/10/29 01:55
 * @description KMP 算法的主要思想是提前判断如何重新开始查找，而这种判断只取决于模式本身。
 * 时间复杂度 O(n+m)
 * @link <a href="https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html">讲解</a>
 * @see LeetCode28
 * @see LeetCode214
 * @see LeetCode1392
 * @see LeetCode1764_kmp
 */

public class KMP implements Search {

    public int strStr(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        char[] s = new char[n + 1];
        char[] p = new char[m + 1];
        int[] ne = next(pattern);
        for (int i = 0; i < n; i++) s[i + 1] = text.charAt(i);
        for (int i = 0; i < m; i++) p[i + 1] = pattern.charAt(i);
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) return i - m;
            // j = ne[j]; 再次继续匹配
        }
        return -1;
    }

    //ne[i]: 前缀s[0: ne[i]]和后缀s[i - ne[i]] : i]的最长子串
    public int[] next(String pattern) {
        int m = pattern.length();
        char[] p = new char[m + 1];
        int[] ne = new int[m + 1];
        for (int i = 0; i < m; i++) p[i + 1] = pattern.charAt(i);
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        return ne;
    }
}
