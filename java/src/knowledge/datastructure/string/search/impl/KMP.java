package knowledge.datastructure.string.search.impl;

import knowledge.datastructure.string.search.Search;
import leetcode.problems.*;

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
 * @see LeetCode3031       将单词恢复初始状态所需的最短时间 II
 */

public class KMP implements Search {

    public int strStr(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        if (m == 0) return 0;
        int[] next = next(pattern);
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && t[i] != p[j]) j = next[j];
            if (t[i] == p[j]) j++;
            if (j == m) return i - m + 1;
        }
        return -1;
    }

    //next[i]表示对应的部分匹配值, s[i - next[i]] : i] == s[0: next[i]]
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
