package basic.datastructure.string.impl;

import basic.datastructure.string.Search;
import leetcode.problems.LeetCode1392;
import leetcode.problems.LeetCode214;
import leetcode.problems.LeetCode28;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/4 22:47
 * @description KMP 算法的主要思想是提前判断如何重新开始查找，而这种判断只取决于模式本身。
 * @link <a href="https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html">讲解</a>
 * @link <a href="https://www.youtube.com/watch?v=3IFxpozBs2I">code</a>
 * @see LeetCode214
 * @see LeetCode28
 * @see LeetCode1392
 */

public class KMP implements Search {

    public int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int i = 0; // index for text
        int j = 0; // index for pattern
        int[] next = makePrefix(pattern);
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return i - j;
            }
            if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    //prefix[i]表示对应的部分匹配值, s[i - prefix[i]] : i] == s[0: prefix[i]]
    //"前缀"和"后缀"的最长的共有元素的长度。
    public int[] makePrefix(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                next[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = next[len - 1];
                } else {
                    next[i] = len;
                    i++;
                }
            }
        }
        return next;
    }
}
