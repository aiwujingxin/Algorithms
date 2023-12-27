package leetcode.problems;

import basic.datastructure.string.impl.KMP;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 20:47
 */
public class LeetCode1392 {

    public String longestPrefix(String s) {
        int n = s.length();
        long prefix = 0, suffix = 0;
        long base = 31, mod = 1000000007, mul = 1;
        int happy = 0;
        for (int i = 1; i < n; ++i) {
            prefix = (prefix * base + (s.charAt(i - 1) - 'a')) % mod;
            suffix = (suffix + (s.charAt(n - i) - 'a') * mul) % mod;
            if (prefix == suffix) {
                happy = i;
            }
            mul = mul * base % mod;
        }
        return s.substring(0, happy);
    }

    public String longestPrefix_kmp(String s) {
        int n = s.length();
        int[] next = new KMP().makePrefix(s);
        return s.substring(0, next[n - 1]);
    }
}
