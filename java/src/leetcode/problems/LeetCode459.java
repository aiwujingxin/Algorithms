package leetcode.problems;

import basic.datastructure.string.search.KMP;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 17:04
 */
public class LeetCode459 {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (check(s, i, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String s, int j, int len) {
        int k = j;
        while (k < s.length()) {
            int right = k;
            int left = 0;
            while (left < len && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right++;
            }
            k += len;
        }
        return k == s.length();
    }

    public boolean repeatedSubstringPattern_KMP(String s) {
        return new KMP().search(s + s, s) == s.length() - 1;
    }
}
