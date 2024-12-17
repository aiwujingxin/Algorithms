package leetcode.problems;


import knowledge.datastructure.string.search.impl.KMP;

public class LeetCode214 {

    public String shortestPalindrome(String s) {
        StringBuilder reversed = new StringBuilder(s).reverse();
        int n = s.length();
        while (!s.substring(0, n).equals(reversed.substring(s.length() - n))) {
            n--;
        }
        return reversed.substring(0, s.length() - n) + s;
    }

    public String shortestPalindrome_kmp(String s) {
        String str = s + "#" + new StringBuilder(s).reverse();
        int[] next = new KMP().next(str);
        return new StringBuilder(s.substring(next[str.length()])).reverse() + s;
    }
}
