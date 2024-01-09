package leetcode.problems;


import knowledge.datastructure.string.impl.KMP;
import knowledge.datastructure.string.impl.RabinKarp;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 16:02
 */
public class LeetCode28 {
    //https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/discuss/2268683/Java-or-Using-KMP

    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int index = 0;
                int hi = i;
                while (index < needle.length() && haystack.charAt(hi) == needle.charAt(index)) {
                    hi++;
                    index++;
                }
                if (index == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr_kmp(String haystack, String needle) {
        return new KMP().search(haystack, needle);
    }

    public int strStr_RabinKarp(String haystack, String needle) {
        return new RabinKarp().search(haystack, needle);
    }
}
