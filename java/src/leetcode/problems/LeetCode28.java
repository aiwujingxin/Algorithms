package leetcode.problems;


import knowledge.datastructure.string.impl.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 16:02
 */
public class LeetCode28 {
    //https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/discuss/2268683/Java-or-Using-KMP

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int s = 0; s <= haystack.length() - needle.length(); s++) {
            int e = s;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(e)) {
                    break;
                }
                e++;
            }
            if (e - s == needle.length()) {
                return s;
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
