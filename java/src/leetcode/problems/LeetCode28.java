package leetcode.problems;

import basic.algorithm.string.KMP;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 01:23
 */
public class LeetCode28 {
    //https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/discuss/2268683/Java-or-Using-KMP
    public int strStr(String haystack, String needle) {
        return new KMP().KMPSearch(haystack, needle);
    }
}
