package leetcode.problems;

import basic.datastructure.string.search.*;

public class LeetCode214_kmp {

    //https://leetcode.cn/problems/shortest-palindrome/solution/tu-jie-kmpsuan-fa-by-yangbingjie/

    public String shortestPalindrome(String s) {
        String kmpstr = s + "#" + new StringBuilder(s).reverse();
        int[] next = new KMP().makePrefix(kmpstr);
        return new StringBuilder(s.substring(next[kmpstr.length() - 1])).reverse() + s;
    }
}
