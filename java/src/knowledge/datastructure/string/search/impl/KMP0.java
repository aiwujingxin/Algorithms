package knowledge.datastructure.string.search.impl;

import knowledge.datastructure.string.search.Search;

/**
 * @author wujingxinit@outlook.com
 * @date 10/29/24 00:54
 * @link <a href="https://www.youtube.com/watch?v=3IFxpozBs2I">code</a>
 */
public class KMP0 implements Search {

    public int strStr(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int i = 0; // index for text
        int j = 0; // index for pattern
        int[] next = makePrefix(pattern);
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
                if (j == m) {
                    return i - j;
                }
            } else if (j != 0) {
                j = next[j - 1];
            } else {
                i++;
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
