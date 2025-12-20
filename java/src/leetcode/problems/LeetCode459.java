package leetcode.problems;

import knowledge.datastructure.string.kmp.KMP;
import knowledge.mathematics.MathUtil;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 17:04
 * @link <a href="https://leetcode.cn/problems/repeated-substring-pattern/solutions/1705527/by-carlsun-2-g3iz/">kmp</a>
 */
public class LeetCode459 {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 1) {
            return false;
        }
        for (int i = 1; i <= n / 2; i++) {
            if (s.length() % i != 0) {
                continue;
            }
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


    public boolean repeatedSubstringPattern_kmp(String s) {
        int n = s.length();
        int[] nx = new KMP().next(s.toCharArray());
        int lps = nx[n - 1];        // 最长前后缀长度
        // 如果 lps > 0 且 n 可以被 (n - lps) 整除，则可由重复子串组成
        return lps > 0 && n % (n - lps) == 0;
    }

    public boolean repeatedSubstringPattern_opt(String s) {
        if (s.length() == 1) {
            return false;
        }
        for (int i = 2; i <= s.length(); i++) {
            if (s.length() % i != 0) {
                continue;
            }
            if (!MathUtil.isPrime(i)) {
                continue;
            }
            // 分成i段，每段长len
            int len = s.length() / i;
            boolean isMatch = true;
            for (int j = len; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j % len)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return true;
            }
        }
        return false;
    }
}
